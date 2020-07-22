package practice08;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String result = super.introduce() + " I am a Teacher.";
        if (klass == null)
            return result + " I teach No Class.";
        return result + " I teach Class " + klass.getNumber() + ".";
    }

    public String introduceWith(Student student) {
        if (student.getKlass().equals(klass)) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        }
        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
    }
}
