package site.zqiusu.config;

import site.zqiusu.service.Payment;

public interface PaymentFactory {

    Payment createPayment(PaymentType type);

    Payment createDefaultPayment();

}
