package designpattern.structure.proxy.dynamicproxy.customproxy.proxy;


import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class CustomProxy {

    private static final String LN = "\r\n";

    /**
     * 1、动态生成Java文件
     * 2、Java文件输出到磁盘，保存为文件$Proxy0.java
     * 3、把Java文件编译成class文件
     * 4、把class文件加载到JVM中
     * 5、返回新的代理对象
     * <p>
     * 试试可以不输出到磁盘 直接加载到JVM不知道行不行
     */
    public static Object newProxyInstance(CustomClassLoader loader,
                                          Class<?>[] interfaces,
                                          CustomInvocationHandler h) throws Exception {
        // 1、动态生成Java文件
        String javaCode = generateCode(interfaces);
//        System.out.println("================================");
//        System.out.println(javaCode);

        // 2、Java文件输出到磁盘，保存为文件$Proxy0.java
        String filePath = CustomProxy.class.getResource("").getPath();
        File f = new File(filePath + "$Proxy0.java");
        FileWriter fileWriter = new FileWriter(f);
        fileWriter.write(javaCode);
        fileWriter.flush();
        fileWriter.close();

        // 3、把Java文件编译成class文件
        // 获取编译器
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(f);
        // 创建编译任务
        JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();
        standardFileManager.close();

        // 4、把class文件加载到JVM中
        Class<?> $Proxy0 = loader.findClass("$Proxy0");
        Constructor<?> constructor = $Proxy0.getConstructor(CustomInvocationHandler.class);
//        f.delete();

        // 5、返回新的代理对象
        return constructor.newInstance(h);
    }

    private static String generateCode(Class<?>[] interfaces) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package designpattern.structure.proxy.dynamicproxy.customproxy.proxy;").append(LN)
                .append("import designpattern.structure.proxy.dynamicproxy.customproxy.client.IPerson;").append(LN)
                .append("import java.lang.reflect.*;").append(LN)
                .append("public final class $Proxy0 implements ");
        for (int i = 0; i < interfaces.length; i++) {
            stringBuilder.append(interfaces[i].getName());
            if (i < interfaces.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(" {").append(LN)
                .append("CustomInvocationHandler h;").append(LN)
                .append("public $Proxy0 (CustomInvocationHandler h) {").append(LN)
                .append("this.h = h;").append(LN)
                .append("}").append(LN);

        for (Class<?> anInterface : interfaces) {
            for (Method method : anInterface.getMethods()) {
                Parameter[] parameters = method.getParameters();

                // 方法签名
                stringBuilder.append("public ").append(method.getReturnType().getName()).append(" ")
                        .append(method.getName()).append("(");

                // 参数列表
                for (int i = 0; i < parameters.length; i++) {
                    stringBuilder.append(parameters[i].getType().getName()).append(" ").append(parameters[i].getName());
                    if (i < parameters.length - 1) {
                        stringBuilder.append(", ");
                    }
                }

                stringBuilder.append("){").append(LN)
                        .append("try {").append(LN)
                        .append("Method m = ").append(anInterface.getName()).append(".class.getMethod(\"")
                        .append(method.getName()).append("\", new Class[]{");
                // 根据class[]获取方法名
                for (int i = 0; i < parameters.length; i++) {
                    stringBuilder.append(parameters[i].getType().getName()).append(".class");
                    if (i < parameters.length - 1) {
                        stringBuilder.append(", ");
                    }
                }
                stringBuilder.append("});").append(LN)
                        .append("Object o = this.h.invoke(this, m, new Object[]{");
                // 反射调用时需传入参数列表
                for (int i = 0; i < parameters.length; i++) {
                    stringBuilder.append(parameters[i].getName());
                    if (i < parameters.length - 1) {
                        stringBuilder.append(", ");
                    }
                }
                stringBuilder.append("});").append(LN);
                // 返回值判断
                if (method.getReturnType() == void.class) {
                    stringBuilder.append("return;");
                } else {
                    stringBuilder.append("return (").append(method.getReturnType().getName()).append(")o;");
                }
                stringBuilder.append("} catch (Error e) {").append(LN)
                        .append("throw e;").append(LN)
                        .append("} catch(Throwable throwable) {").append(LN)
                        .append("throw new UndeclaredThrowableException(throwable);").append(LN)
                        .append("}").append(LN)
                        .append("}").append(LN)
                        .append(LN);
            }
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
