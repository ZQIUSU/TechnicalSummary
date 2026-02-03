package site.zqiusu.service.Impl;

import site.zqiusu.config.PaymentStatus;
import site.zqiusu.service.Payment;

public class ALiPayPayment implements Payment {
    private String appId;
    private String merchantId;
    private String privateKey;

    public ALiPayPayment(String appId, String merchantId, String privateKey) {
        this.appId = appId;
        this.merchantId = merchantId;
        this.privateKey = privateKey;
    }

    @Override
    public PaymentStatus pay(double amount, String orderId) {
        System.out.println("支付宝支付: 订单" + orderId + ", 金额" + amount);
        // 模拟支付过程
        System.out.println("调用支付宝SDK...");
        System.out.println("签名验证: " + privateKey.substring(0, 10) + "...");
        System.out.println("跳转到支付宝支付页面...");
        return PaymentStatus.SUCCESS;
    }

    @Override
    public PaymentStatus queryStatus(String orderId) {
        System.out.println("查询支付宝交易状态: " + orderId);
        return PaymentStatus.SUCCESS;
    }

    @Override
    public String getName() {
        return "支付宝支付";
    }
}
