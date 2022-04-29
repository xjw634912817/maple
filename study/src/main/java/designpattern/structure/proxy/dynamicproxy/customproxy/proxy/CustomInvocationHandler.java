package designpattern.structure.proxy.dynamicproxy.customproxy.proxy;

import java.lang.reflect.Method;

public interface CustomInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
