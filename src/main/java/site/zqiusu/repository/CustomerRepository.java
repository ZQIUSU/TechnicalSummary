package site.zqiusu.repository;

import org.springframework.data.repository.CrudRepository;
import site.zqiusu.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
