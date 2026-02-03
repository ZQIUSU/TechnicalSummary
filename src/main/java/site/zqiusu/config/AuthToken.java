package site.zqiusu.config;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AuthToken {
    private String AlipayappId = "appid";
    private String AlipaymerchantId = "merchantId";
    private String AilpayprivateKey = "privateKey";
    private String WeChatappId = "WeChatappId";
    private String WeChatmchId = "mchId";
    private String WeChatapiKey = "apiKey";
}
