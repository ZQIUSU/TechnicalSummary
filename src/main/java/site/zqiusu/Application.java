package site.zqiusu;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import site.zqiusu.model.Coffee;
import site.zqiusu.model.CoffeeOrder;
import site.zqiusu.repository.CoffeeOrderRepository;
import site.zqiusu.repository.CoffeeRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner{//实现这个接口也是做定制，来打印日志

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @Override
    public void run(String... args) throws Exception {
        init();
        findOrders();
    }

    private void init(){//初始化数据表
        Coffee espresso = Coffee.builder()
                .coffeeName("espresso")
                .price("20.0CNY")
                .build();
        coffeeRepository.save(espresso);
        log.info("Coffee:{}",espresso);

        Coffee latte = Coffee.builder()
                .coffeeName("latte")
                .price("30.0CNY")
                .build();
        coffeeRepository.save(latte);
        log.info("Coffee:{}",latte);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("zzp")
                .items(Collections.singletonList(espresso))
                .state(1)
                .build();
        coffeeOrderRepository.save(order);
        log.info("Order:{}",order);

        order = CoffeeOrder.builder()
                .customer("wyc")
                .items(Arrays.asList(espresso,latte))
                .state(1)
                .build();
        coffeeOrderRepository.save(order);
        log.info("Order:{}",order);


    }

    private void findOrders(){
        //按照id降序输出coffee表
        coffeeRepository.findAll(Sort.by(Sort.Direction.DESC,"id"))
                .forEach(c->log.info("loading:{}",c));

        //按照日期降序id升序找出前三条订单(id代表创建时间，日期是指更新时间，也就是最后做好的三笔订单按照id升序输出)
        List<CoffeeOrder> list = coffeeOrderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
        log.info("findTop3ByOrderByUpdateTimeDescIdAsc:{}",getJoinedOrderId(list));

        //查询**所有订单
        list = coffeeOrderRepository.findByCustomerOrderById("wyc");
        log.info("findByCustomerOrderById:{}",getJoinedOrderId(list));

        list.forEach(o -> {
            log.info("Order:{}",o.getId());
            o.getItems().forEach(i -> log.info("Item:{}",i)
            );
        });

        list = coffeeOrderRepository.findByItemsCoffeeName("latte");
        log.info("findByItemsCoffeeName:{}",getJoinedOrderId(list));


        log.info("Hello");

        log.info("Hello");

    }

    //只输出id的集合，用逗号隔开
    private String getJoinedOrderId(List<CoffeeOrder> list){
        return list.stream().map(o -> o.getId().toString())
                .collect(Collectors.joining(","));
    }

}
