package site.zqiusu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zqiusu.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RestController
public class CustomerController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/hello")
    public String index(){
        return "Hello world";
    }

    @RequestMapping("/getCustomer")
    public Customer getCustomer(){
        Customer customer = new Customer();
        customer.setName("小明");
        customer.setPassWord("123456");
        return customer;
    }


}
