package site.zqiusu.webconfiguration;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

//druid的定制，继承FilterEventAdapter，重写这几个方法就行了
@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("Before Connection!");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("After Connection!");
    }
}
