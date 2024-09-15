package Reminder;

import java.util.List;

public class Employee {
    private String name;
    private String surname;
    private int age;


    private List<String> skils;

    public Employee(String name, String surname, int age, List<String> skils) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.skils = skils;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSkils() {
        return skils;
    }

    public void setSkils(List<String> skils) {
        this.skils = skils;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", skils=" + skils +
                '}';
    }
}
