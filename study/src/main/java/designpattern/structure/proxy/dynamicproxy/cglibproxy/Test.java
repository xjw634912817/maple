package designpattern.structure.proxy.dynamicproxy.cglibproxy;


import net.sf.cglib.core.DebuggingClassWriter;

public class Test {
    /**
     * Cglib采用继承的方式，覆盖父类的方法
     * JDK采用实现的方式，必须要求代理的目标对象一定要实现一个借口
     * 思想：都是通过生成字节码，重组成一个新的类
     * <p>
     * JDK代理对于用户来说，依赖更强，调用也更复杂
     * Cglib 对目标类没有任何要求
     * Cglib 性能高、效率高，底层没有用到反射
     * cglib 有个坑：会忽略final修饰的方法
     * <p>
     * JDK Proxy 生成逻辑较为简单，执行效率要低，每次都要用反射
     */
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\cglib_proxy_class");

        CglibMeiPo cglibMeiPo = new CglibMeiPo();
        ZhangSan zhangSan = (ZhangSan) cglibMeiPo.getInstance(ZhangSan.class);
        zhangSan.findLove();
        zhangSan.speak("cglib");
        zhangSan.mySelfMethod();
    }
}
