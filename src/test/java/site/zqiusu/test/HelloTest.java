package site.zqiusu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //预期抛出的错误，如果抛出了就通过
    @Test
    public void test() {
        jdbcTemplate.execute("INSERT INTO customer (id,name) VALUES (1,'zzp')");
        jdbcTemplate.execute("INSERT INTO customer (id,name) VALUES (2,'wyc')");
    }
}
