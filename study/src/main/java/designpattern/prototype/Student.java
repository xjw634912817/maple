package designpattern.prototype;

public class Student implements Cloneable {
    private int id;
    private String name;
    private A a;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", a=" + a +
                '}';
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    static class A {
        private String Name;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }
    }
}
