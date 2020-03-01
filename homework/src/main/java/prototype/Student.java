package prototype;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class Student {

    private Integer id;
    private String name;
    private List<String> courses;

    public Student deepClone() {
        String jsonString = JSON.toJSONString(this);
        return JSON.parseObject(jsonString, Student.class);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
