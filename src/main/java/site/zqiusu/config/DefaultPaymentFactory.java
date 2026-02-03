package site.zqiusu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import site.zqiusu.service.Impl.ALiPayPayment;
import site.zqiusu.service.Impl.WeChatPayment;
import site.zqiusu.service.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Configuration
public class DefaultPaymentFactory implements PaymentFactory{

    @Autowired
    private AuthToken authToken;

    @Override
    public Payment createPayment(PaymentType type) {
        if(type == PaymentType.ALI_PAY){
            return new ALiPayPayment(authToken.getAlipayappId(), authToken.getAlipaymerchantId(), authToken.getAilpayprivateKey());
        }else if(type == PaymentType.WECHAT_PAY){
            return new WeChatPayment(authToken.getWeChatappId(), authToken.getWeChatmchId(), authToken.getWeChatapiKey());
        }else{
            throw new IllegalArgumentException("不支持的参数类型");
        }
    }

    @Override
    public Payment createDefaultPayment() {
        return new ALiPayPayment(authToken.getAlipayappId(), authToken.getAlipaymerchantId(), authToken.getAilpayprivateKey());
    }
}
