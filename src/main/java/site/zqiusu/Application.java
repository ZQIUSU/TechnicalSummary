package site.zqiusu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner{//实现这个接口也是做定制，来打印日志

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @Override
    public void run(String... args) throws Exception {
        customerService.insert();
        log.info("{}",jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customer WHERE ID = 1", Long.class));

        try{
            customerService.insertThenRollback();
        } catch (Exception e) {
            log.info("{}",jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customer WHERE ID = 2", Long.class));
        }

        try{
            customerService.invokeInsertThenRollback();
        } catch (Exception e) {
            log.info("{}",jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customer WHERE ID = 2", Long.class));
        }
    }
}
