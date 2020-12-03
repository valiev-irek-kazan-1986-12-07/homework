package Person;

import java.util.Random;

public class Person {

    private String name;
    private int age;
    private Sex sex;

    public Person (String name, int age, Sex sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static String personGetSex(Person person){
        return person.sex.getSex();
    }

    public static String personToString(Person person){
        return person.getName() + " " + person.getAge() + " " +  person.sex.getSex();
    }

    public Sex getSex(){
        return sex;
    }

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
    }
