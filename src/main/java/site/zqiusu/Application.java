package site.zqiusu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@SpringBootApplication
public class Application  implements CommandLineRunner{//实现这个接口也是做定制，来打印日志

    //注入datasource来查看相关的配置
    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws SQLException {
        showConnection();
    }

    private void showConnection()  {
        log.info(dataSource.toString());
        try (Connection connection = dataSource.getConnection()) {
            log.info(connection.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
