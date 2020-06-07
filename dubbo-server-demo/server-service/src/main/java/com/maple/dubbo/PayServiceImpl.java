package com.maple.dubbo;

public class PayServiceImpl implements IPayService {
    @Override
    public void pay(int i) {
        System.out.println("服务端收到支付请求： " + i);
    }
}
