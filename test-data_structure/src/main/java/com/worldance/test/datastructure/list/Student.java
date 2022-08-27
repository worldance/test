package com.worldance.test.datastructure.list;

public class Student {

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        else if (this.getClass() != obj.getClass()) {
            return false;
        }

        Student st = (Student) obj;

        if (st.getName().equals(this.name) && st.getAge() == this.age) {
            return true;
        }

        return false;
    }

}
