package site.zqiusu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void insert() {
        jdbcTemplate.execute("INSERT INTO customer (id) VALUES (1)");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)//抛出Exception异常就回滚
    public void insertThenRollback() throws Exception {
        jdbcTemplate.execute("INSERT INTO customer (id) VALUES (2)");
        throw new Exception();
    }

    @Override//在类内部调用带有@Transactional的注解
    public void invokeInsertThenRollback() throws Exception {
        insertThenRollback();
    }
}


//在方法上添加@Transactional注解其实是为这个方法添加了一个代理，这个类就是个代理类