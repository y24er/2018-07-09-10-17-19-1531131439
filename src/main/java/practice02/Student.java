package practice02;

public class Student extends Person{
    private String klass;

    public Student(String name, int age) {
        super(name, age);
    }


    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return "I am a Student. I am at "+klass+".";
    }
}
