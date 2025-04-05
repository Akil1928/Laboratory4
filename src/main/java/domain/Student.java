package domain;

import java.util.Objects;

public class Student implements Person, Comparable<Student> {
    private String id;
    private String name;
    private int age;
    private String address;

    public Student(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(String id) {
        this.id = id;
    }

    private double studyHours(){
        return age / 2;
    }
    @Override
    public boolean equals(Person other) {
        Student student = (Student)  other;

        return student.id.equals(id);


    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getAddress() {
        return "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Student {" + "id=" + id + ", name=" +
                name + ", age=" + age + ", study hours="+studyHours()+", address="+address+'}';
    }
}
