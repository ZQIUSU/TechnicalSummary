package site.zqiusu.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "coffee")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class Coffee extends BaseEntity{

    @Column(name = "coffee_name")
    private String coffeeName;

    private String price;

}
