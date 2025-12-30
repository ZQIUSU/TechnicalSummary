package site.zqiusu.jpa.service;


import org.springframework.stereotype.Service;
import site.zqiusu.jpa.entity.WeatherEntity;
import site.zqiusu.jpa.repository.WeatherEntityRepository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WeatherEntityService {

    @Resource
    public WeatherEntityRepository repository;

    public WeatherEntity save(String city, String temperature) {
        WeatherEntity record = new WeatherEntity();
        record.setCity(city);
        record.setTemperature(temperature);
        record.setCreateTime(new Date());
        return repository.save(record);
    }

    public List<WeatherEntity> listByCity(String city) {
        return repository.findByCity(city);
    }
}
