package site.zqiusu;

import apple.laf.JRSUIUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;
import java.util.*;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner{//实现这个接口也是做定制，来打印日志


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @Override
    public void run(String... args) throws Exception {
//        HashMap<String,Integer> map = new HashMap<>();
//        map.put("zzp",25);
//        map.put("wyc",24);
//        System.out.println(map.values());

        );
    }

}
