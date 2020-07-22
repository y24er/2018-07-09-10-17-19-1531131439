package practice09;

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
            if (leader.getId() == (this.getId())) {
                return result + " I am Leader of Class " + klass.getNumber() + ".";
            }
        }
        return result + " I am at Class " + klass.getNumber() + ".";
    }
}
