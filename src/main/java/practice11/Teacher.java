package practice11;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements JoinListener {
    private List<Klass> classes;
    private JoinListener joinListener;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = new ArrayList<Klass>();
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for (Klass klass : classes) {
            klass.attch(this);
        }
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public void setClasses(List<Klass> classes) {
        this.classes = classes;
    }

    @Override
    public String introduce() {
        String result = super.introduce() + " I am a Teacher.";
        if (classes.size() == 0)
            return result + " I teach No Class.";
        String klasses = "";
        for (int i = 0; i < classes.size(); i++) {
            Klass klass = classes.get(i);
            if (i != classes.size() - 1) {
                klasses += klass.getNumber() + ", ";
            } else {
                klasses += klass.getNumber();
            }
        }
        return result + String.format(" I teach Class %s.", klasses);
    }

    public boolean isTeaching(Student student) {
        boolean isTeaching = false;
        for (Klass klass : classes) {
            if (klass.equals(student.getKlass())) {
                isTeaching = true;
            }
        }
        return isTeaching;
    }

    public String introduceWith(Student student) {

        if (isTeaching(student)) {
            return super.introduce() + String.format(" I am a Teacher. I teach %s.", student.getName());
        }
        return super.introduce() + String.format(" I am a Teacher. I don't teach %s.", student.getName());
    }

    @Override
    public void update(Student student) {
        System.out.println(String.format("I am %s. I know %s has joined Class %d.", this.getName(), student.getName(), student.getKlass().getNumber()));
    }
}

