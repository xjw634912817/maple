package prototype;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setId(1);
        student.setName("小明");
        Student clone = student.clone();
        clone.setName("123");
        System.out.println(student);
        System.out.println(clone);
    }
}
