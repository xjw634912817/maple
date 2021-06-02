package designpattern.proxy.dynamicproxy.jdkproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeiPo implements InvocationHandler {
    private Object target;

    // 入参其实可以改成Object 代理所有有实现接口的对象
    public Object getInstance(Object target) {
        this.target = target;
        Class<?> targetClass = target.getClass();
        return Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), this);
    }

    @Override
    public java.lang.Object invoke(java.lang.Object proxy, Method method, java.lang.Object[] args) throws Throwable {
        System.out.println("before");
        java.lang.Object result = method.invoke(this.target, args);
        System.out.println("after");
        return result;
    }
}
