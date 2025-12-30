package site.zqiusu.dto;

import lombok.Data;

/*
    获取天气数据传输对象
 */
@Data
public class WeatherInfoDTO {
//    private WeatherInfoDTO weatherInfoDTO;


    private String temperature;
    private String condition;
    private String humidity;
    private String windSpeed;
}
