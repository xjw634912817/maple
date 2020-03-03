package designpattern.proxy.dynamicproxy.customproxy.client;


import designpattern.proxy.dynamicproxy.customproxy.proxy.CustomClassLoader;
import designpattern.proxy.dynamicproxy.customproxy.proxy.CustomInvocationHandler;
import designpattern.proxy.dynamicproxy.customproxy.proxy.CustomProxy;

import java.lang.reflect.Method;

public class CustomMeiPo implements CustomInvocationHandler {
    private Object target;

    public Object getInstance(Object target) throws Exception {
        this.target = target;
        Class<?> targetClass = target.getClass();
        return CustomProxy.newProxyInstance(new CustomClassLoader(), targetClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(this.target, args);
        System.out.println("after");
        return result;
    }
}
