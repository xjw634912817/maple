package designpattern.prototype;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setId(1);
        student.setName("小明");
        Student clone = student.clone();
        clone.setName("123");
        Student.A a = new Student.A();
        a.setName("引用");
        clone.setA(a);
        Student clone2 = student.clone();
        System.out.println(student);
        System.out.println(clone);
        System.out.println(clone2);
        add(clone);
    }

    public static  <T extends Student & Cloneable> T add(T t) {
        return t;
    }
}
