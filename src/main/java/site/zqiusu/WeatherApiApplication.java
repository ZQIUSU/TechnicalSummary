package site.zqiusu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WeatherApiApplication {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(WeatherApiApplication.class, args);

    }
}
