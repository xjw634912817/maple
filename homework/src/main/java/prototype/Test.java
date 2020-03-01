package prototype;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setName("小明");
        List<String> courses = new ArrayList<>();
        courses.add("语文");
        courses.add("数学");
        student.setCourses(courses);
        Student clone = student.deepClone();
        clone.setName("123");
        clone.getCourses().add("英语");
        System.out.println(student);
        System.out.println(clone);
    }
}
