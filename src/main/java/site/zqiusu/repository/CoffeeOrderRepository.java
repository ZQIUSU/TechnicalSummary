package site.zqiusu.repository;

import site.zqiusu.model.CoffeeOrder;

import java.util.List;

public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {

    //查询**所有的订单(通过id顺序排序)
    List<CoffeeOrder> findByCustomerOrderById(String customer);

    List<CoffeeOrder> findByItemsCoffeeName(String name);
}
