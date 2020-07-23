package practice11;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Person) {
            return this.id == ((Person) obj).getId();
        } else
            return false;
    }
    
    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }
}
