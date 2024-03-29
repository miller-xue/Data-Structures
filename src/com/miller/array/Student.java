package com.miller.array;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("miller", 1));
        studentArray.addLast(new Student("tom", 1));
        studentArray.addLast(new Student("Bob", 1));
        System.out.println(studentArray);
    }
}
