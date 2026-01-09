package site.zqiusu.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "coffee_order")
@ToString(callSuper = true)
public class CoffeeOrder extends BaseEntity{

    private String customer;

    @ManyToMany
    @JoinTable(name = "coffee_order_join")
    private List<Coffee> items;
    //连结一个表，coffee_order_id也就是当前表的主键，另一个是Coffee表的id->items_id

    @Column(nullable = false)
    private Integer state;

}

