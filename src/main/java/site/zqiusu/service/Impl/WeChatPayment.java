package site.zqiusu.service.Impl;

import site.zqiusu.config.PaymentStatus;
import site.zqiusu.service.Payment;

public class WeChatPayment implements Payment {
    private String appId;
    private String mchId;
    private String apiKey;

    public WeChatPayment(String appId, String mchId, String apiKey) {
        this.appId = appId;
        this.mchId = mchId;
        this.apiKey = apiKey;
    }

    @Override
    public PaymentStatus pay(double amount, String orderId) {
        System.out.println("微信支付: 订单" + orderId + ", 金额" + amount);
        // 模拟支付过程
        System.out.println("调用微信支付API...");
        System.out.println("生成预付单...");
        System.out.println("唤起微信支付...");
        return PaymentStatus.SUCCESS;
    }

    @Override
    public PaymentStatus queryStatus(String orderId) {
        System.out.println("查询微信支付交易状态: " + orderId);
        return PaymentStatus.SUCCESS;
    }

    @Override
    public String getName() {
        return "微信支付";
    }
}
