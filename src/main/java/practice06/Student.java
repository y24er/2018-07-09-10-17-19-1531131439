package practice06;

public class Student extends Person {
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
        return super.introduce() + "I am a Student. I am at " + klass + ".";
    }
}
