package site.zqiusu.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import site.zqiusu.jpa.entity.WeatherEntity;
import site.zqiusu.jpa.service.WeatherEntityService;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Resource
    private WeatherEntityService service;

    @PostMapping("/save")
    public WeatherEntity save(@RequestParam String city,
                              @RequestParam String temperature) {
        WeatherEntity weatherEntity = service.save(city, temperature);
        log.info(String.valueOf(weatherEntity));
        return weatherEntity;
    }

    @GetMapping("/get")
    public List<WeatherEntity> get(@RequestParam String city) {
        List<WeatherEntity> weatherEntities = service.listByCity(city);
        log.info(weatherEntities.toString());
        return weatherEntities;
    }
}
