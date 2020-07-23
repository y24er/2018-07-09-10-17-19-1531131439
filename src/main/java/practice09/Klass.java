package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> students;

    public Klass(int number) {
        this.number = number;
        students = new ArrayList<Student>();
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student leader) {
        if (!leader.getKlass().equals(this)) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = leader;
    }

    public void appendMember(Student student) {
        students.add(student);
    }
}
