package designpattern.creation.prototype;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class Test {
    // Cloneable接口默认实现为浅克隆，如需深克隆需自己实现
    public static void main(String[] args) throws CloneNotSupportedException {
        verifyCloneMethodIsShallowCopy();

        System.out.println("========== split line ==========");

        verifyCloneMethodOfArrayListIsShallowCopy();
    }

    private static void verifyCloneMethodOfArrayListIsShallowCopy() {
        Student student = new Student(1, "Tom", new Student.A("Tom A"));
        Student student2 = new Student(2, "Jerry", new Student.A("Jerry A"));
        ArrayList<Student> students = Lists.newArrayList(student, student2);
        ArrayList<Student> studentsFromClone = (ArrayList<Student>) students.clone();
        System.out.println(students);
        System.out.println(studentsFromClone);
        System.out.println(students == studentsFromClone);

        System.out.println(students.get(0) == studentsFromClone.get(0));
    }

    private static void verifyCloneMethodIsShallowCopy() throws CloneNotSupportedException {
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
