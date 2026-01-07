package site.zqiusu;

import org.springframework.stereotype.Service;


public interface CustomerService {

    void insert();

    void insertThenRollback() throws Exception;

    void invokeInsertThenRollback() throws Exception;
}
