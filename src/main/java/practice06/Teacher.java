package practice06;

public class Teacher extends Person {
    private String klass;

    public Teacher(String name, int age) {
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
        if (klass == null)
            return super.introduce() + "I am a Teacher. I teach No Class.";
        return super.introduce() + "I am a Teacher. I teach " + klass + ".";
    }

}
