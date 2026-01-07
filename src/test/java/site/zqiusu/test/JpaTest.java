package site.zqiusu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.zqiusu.model.Customer;
import site.zqiusu.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void jpa_test(){
        Customer customer = new Customer(1L,"zzp");
        repository.save(customer);
    }

}
