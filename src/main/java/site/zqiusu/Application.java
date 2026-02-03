package site.zqiusu;

import apple.laf.JRSUIUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import site.zqiusu.config.DefaultPaymentFactory;
import site.zqiusu.config.PaymentStatus;
import site.zqiusu.config.PaymentType;
import site.zqiusu.service.Payment;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;
import java.util.*;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner{//实现这个接口也是做定制，来打印日志
    @Autowired
    private DefaultPaymentFactory paymentFactory;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Payment payment = paymentFactory.createPayment(PaymentType.WECHAT_PAY);
        System.out.println(payment.getName());
        PaymentStatus WeChatPayStatus = payment.pay(10, "0001");

        Payment payment1 = paymentFactory.createDefaultPayment();
        System.out.println(payment1.getName());
    }

}
