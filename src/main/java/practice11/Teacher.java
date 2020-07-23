package practice11;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements JoinListener, LeaderListener {
    private List<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = new ArrayList<Klass>();
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for (Klass klass : classes) {
            klass.attachJoinListener(this);
            klass.attachLeaderListener(this);
        }
    }

    public List<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce() {
        String result = super.introduce() + " I am a Teacher.";
        if (classes.isEmpty())
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
    public void joinUpdate(Student student) {
        System.out.print(String.format("I am %s. I know %s has joined Class %d.\n", this.getName(), student.getName(), student.getKlass().getNumber()));
    }

    @Override
    public void leaderUpdate(Student student) {
        System.out.print(String.format("I am %s. I know %s become Leader of Class %d.\n", this.getName(), student.getName(), student.getKlass().getNumber()));
    }
}

