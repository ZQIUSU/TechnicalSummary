package site.zqiusu.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * 天气数据库对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetWeatherInfoResponse {

    /* 纬度 */
    private Double latitude;

    /* 经度 */
    private Double longitude;

    /* 生成时间（毫秒） */
    private Double generationtimeMs;

    /* UTC偏移秒数 */
    private Integer utcOffsetSeconds;

    /* 时区 */
    private String timezone;

    /* 时区缩写 */
    private String timezoneAbbreviation;

    /* 海拔高度 */
    private Double elevation;

    /* 当前天气单位 */
    private CurrentUnits currentUnits;

    /* 当前天气数据 */
    private Current current;

    /* 每小时天气单位 */
    private HourlyUnits hourlyUnits;

    /* 每小时天气数据 */
    private Hourly hourly;

    /**
     * 当前天气单位类
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CurrentUnits {
        /* 时间单位 */
        private String time;

        /* 间隔单位 */
        private String interval;

        /* 2米温度单位 */
        private String temperature2m;

        /* 10米风速单位 */
        private String windSpeed10m;
    }

    /**
     * 当前天气数据类
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Current {
        /* 时间 */
        private String time;

        /* 间隔（秒） */
        private Integer interval;

        /* 2米温度（°C） */
        private Double temperature2m;

        /* 10米风速（km/h） */
        private Double windSpeed10m;
    }

    /**
     * 每小时天气单位类
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HourlyUnits {
        /* 时间单位 */
        private String time;

        /* 2米温度单位 */
        private String temperature2m;

        /* 2米相对湿度单位 */
        private String relativeHumidity2m;

        /* 10米风速单位 */
        private String windSpeed10m;
    }

    /**
     * 每小时天气数据类
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Hourly {
        /* 时间列表 */
        private List<String> time;

        /* 2米温度列表（°C） */
        private List<Double> temperature2m;

        /* 2米相对湿度列表（%） */
        private List<Integer> relativeHumidity2m;

        /* 10米风速列表（km/h） */
        private List<Double> windSpeed10m;
    }
}
