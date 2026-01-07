package site.zqiusu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import site.zqiusu.model.Customer;
import site.zqiusu.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner{//实现这个接口也是做定制，来打印日志

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer(1L,"zzp");
        repository.save(customer);
//        Optional<Customer> byId = repository.findById(1L);

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(2L,"wyc"));
        customers.add(new Customer(3L,"lalala"));
        customers.add(new Customer(2L,"wowowo"));
        repository.saveAll(customers);
        Iterable<Customer> all = repository.findAll();
        for(Customer customer1 : all){
            System.out.println(customer1);
        }
    }
}
