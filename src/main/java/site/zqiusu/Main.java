package site.zqiusu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import site.zqiusu.dto.WeatherInfoDTO;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://api.open-meteo.com/v1/forecast";
        String latitude = "30";
        String longitude = "60";
        try (CloseableHttpClient httpClient =  HttpClients.createDefault();){
            //构造Url部分
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameter("latitude", latitude)
                    .addParameter("longitude", longitude)
                    .addParameter("daily", "temperature_2m_max,temperature_2m_min")
                    .addParameter("hourly", "temperature_2m")
                    .addParameter("current","temperature_2m")
                    .addParameter("timezone","Asia/Singapore")
                    .addParameter("forecast_days","1");

            //封装请求
            HttpGet request = new HttpGet(uriBuilder.build());
            request.setHeader("Accept", "application/json");

            //执行http请求
            CloseableHttpResponse execute = httpClient.execute(request);
            HttpEntity entity1 = execute.getEntity();

            //将返回的响应的实体转换为String类型
            String responseBody = EntityUtils.toString(entity1, "UTF-8");
            JSONObject jsonObject = JSON.parseObject(responseBody);

            WeatherInfoDTO weatherInfoDTO = new WeatherInfoDTO();
            weatherInfoDTO.setTemperature(jsonObject.getJSONObject("hourly").getJSONArray("temperature_2m").get(0).toString());
            weatherInfoDTO.setCondition("良好");
            weatherInfoDTO.setHumidity("0%");
            weatherInfoDTO.setWindSpeed("大风");


        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
