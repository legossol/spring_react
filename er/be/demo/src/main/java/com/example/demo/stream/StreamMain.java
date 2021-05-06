package com.example.demo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.example.demo.stream.RefUtil.*;

class Student implements Comparable<Student> {
    private String name;
    private int grade;
    private int score;

    private String username;

    public Student(String name, int grade, int score, String username) {
        this.name = name;
        this.grade = grade;
        this.score = score;
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        return String.format("[name: %s, grade: %d, score: %d, username: %3s]", name, grade, score, username);
    }

    @Override
    public int compareTo(Student o) {
        return o.getScore() - this.grade;
    }

    public Student(String username) {
        this.username = username;
    }
}

public class StreamMain {
    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("메뉴: 0번, EXIT 1. 학년 오름차순, 2. 성적 내림차순 3. 이름 오름차순, 4. ID 오름차순(소문자) 5. 성적 오름차순 6. ID 대문자");
            switch (scanner.nextInt()) {
            case 0:
                return;
            case 1:
                ascGrade().forEach(System.out::println);
                break;
            case 2:
                descScore().forEach(System.out::println);
                break;
            case 3:
                ascName().forEach(System.out::println);
                break;
            case 4:
                ascUsername().forEach(System.out::println);
                break;
            case 5:
                ascScore().forEach(System.out::println);
                break;
            case 6:

                break;
            default:

                break;

            }
        }

        // new StreamUtil().arrayToList(new String[] { "a", "b", "v"
        // }).forEach(System.out::println);
        // System.out.println(RefUtil.strToInt.apply("1"));
    }

    public static Stream<Student> makeStream() {

        DummyGenerator dum = new DummyGenerator();

        return Stream.of(
                new Student(dum.makeName(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(100, 300),
                        dum.makeUsername()),
                new Student(dum.makeName(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(100, 300),
                        dum.makeUsername()),
                new Student(dum.makeName(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(100, 300),
                        dum.makeUsername()),
                new Student(dum.makeName(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(100, 300),
                        dum.makeUsername()),
                new Student(dum.makeName(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(100, 300),
                        dum.makeUsername()),
                new Student(dum.makeName(), rangeBelowRandom.apply(1, 3), rangeBelowRandom.apply(100, 300),
                        dum.makeUsername()));
    }

    public static Stream<Student> ascGrade() {
        return makeStream().sorted(Comparator.comparing(Student::getGrade).thenComparing(Comparator.reverseOrder()));
    }

    public static Stream<Student> ascScore() {
        return makeStream().sorted(Comparator.comparing(Student::getScore).thenComparing(Comparator.reverseOrder()));
    }

    public static Stream<Student> ascName() {

        return makeStream().sorted(Comparator.comparing(Student::getName).thenComparing(Comparator.reverseOrder()));
    }

    public static Stream<Student> ascUsername() {
        return makeStream().sorted(Comparator.comparing(Student::getUsername).thenComparing(Comparator.reverseOrder()));
    }

    public static Stream<Student> descScore() {

        return makeStream().sorted(Comparator.comparing(Student::getScore).reversed());
    }

    // public static Stream<Student> upperCase() {
    // }

}
