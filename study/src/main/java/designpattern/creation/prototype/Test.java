package designpattern.creation.prototype;

public class Test {
    // Cloneable接口默认实现为浅克隆，如需深克隆需自己实现
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setId(1);
        student.setName("小明");

        Student clone = student.clone();
        clone.setName("123");
        clone.setA(new Student.A("引用"));

        Student clone2 = clone.clone();
        clone2.getA().setName("变更引用");
        System.out.println(student);
        System.out.println(clone);
        System.out.println(clone2);
    }
}
