package site.zqiusu.controller;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import site.zqiusu.dto.WeatherInfoDTO;

import java.io.IOException;
import java.net.URISyntaxException;

/*
    获取天气控制器
 */
@RestController
@CrossOrigin("*")
public class GetWeatherInfoController {

    private static final Logger logger = LoggerFactory.getLogger(GetWeatherInfoController.class);
/*
    https:api.open-meteo.com/v1/forecast?
    latitude=34.3813
    longitude=109.0453
    daily=temperature_2m_max,temperature_2m_min
    hourly=temperature_2m
    current=temperature_2m
    timezone=Asia%2FSingapore
    forecast_days=1
*/
    @GetMapping("/weather")
    public WeatherInfoDTO getWeather(@RequestParam String latitude ,@RequestParam String longitude) throws ParseException {



        //调用open-meteo的接口
        String url = "https://api.open-meteo.com/v1/forecast";

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

        logger.info(String.valueOf(weatherInfoDTO));

        return weatherInfoDTO;

//            return httpClient.execute(request, response -> {
//                int statusCode = response.getCode();
//                if (statusCode >= 200 && statusCode < 300) {
//                    HttpEntity entity = response.getEntity();
//                    return entity != null ? EntityUtils.toString(entity) : null;
//                } else {
//
//                    System.out.println(response.getEntity());
//                    throw new RuntimeException("Failed with HTTP error code : " + statusCode);
//                }
//            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


}
