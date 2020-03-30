package jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapTest {

    List<Object> objects = new ArrayList<>();

    public static void main(String[] args) {
        HeapTest heapTest = new HeapTest();
        while (true) {
            heapTest.objects.add(new Person());
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
