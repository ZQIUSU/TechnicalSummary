package site.zqiusu.service;

import site.zqiusu.config.PaymentStatus;

public interface Payment {

    PaymentStatus pay(double amount, String orderId);

    PaymentStatus queryStatus(String orderId);

    String getName();
}
