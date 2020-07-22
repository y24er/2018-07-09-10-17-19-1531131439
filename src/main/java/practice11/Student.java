package practice11;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
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
        String result = super.introduce() + " I am a Student.";
        Student leader = this.getKlass().getLeader();
        if (leader != null) {
            if (this.equals(leader)) {
                return result + String.format(" I am Leader of Class %d.", klass.getNumber());
            }
        }
        return result + String.format(" I am at Class %d.", klass.getNumber());
    }
}