package jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapTest {

    List<Object> objects = new ArrayList<>();

    /**
     * JVM启动参数：设置堆内存初始化大小和最大值
     * -Xmx20M -Xms20M
     */
    public static void main(String[] args) {
        HeapTest heapTest = new HeapTest();
        while (true) {
            heapTest.objects.add(new Person());
            System.out.println(heapTest.objects.size());
        }
    }

    static class Person {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
