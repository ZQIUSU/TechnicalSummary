package site.zqiusu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner{//实现这个接口也是做定制，来打印日志

//    @Autowired
//    private AccountsReceivableRepository repository;
//
//    @Autowired
//    private CoffeeRepository coffeeRepository;
//
//    @Autowired
//    private CoffeeOrderRepository coffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @Override
    public void run(String... args) throws Exception {
        test_add();
//        test_addAll();
    }



    public void test_add(){
        //ArrayList的扩容机制，一开始容量是0，添加一个元素后就是10，达到上限后扩容1.5倍
        ArrayList<Integer> list = new ArrayList<>(4);
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);//隐式调用toString()

        list.clear();
        System.out.println(list);
    }

    //addAll之后容量直接是添加之后的元素总数
    public void test_addAll() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(7, 8, 9, 10,11,12));
        getArrayListLength(A1);
        A1.addAll(4,A2);
        for (int i:A1){
            System.out.print(i+" ");
            getArrayListLength(A1);
        }
        A1.add(111);
        getArrayListLength(A1);
    }

    //拿到ArrayList的容量
    //通过反射拿到存储元素的数组elementData，然后转换为Object[]对象，打印出长度，也就是容量
    public void getArrayListLength(ArrayList<?> list) throws NoSuchFieldException, IllegalAccessException {
        Field elementDataField = ArrayList.class.getDeclaredField("elementData");
        elementDataField.setAccessible(true);
        Object[] o = (Object[] ) elementDataField.get(list);
        System.out.println("数组的容量是："+o.length);
    }
}
