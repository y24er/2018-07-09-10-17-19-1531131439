package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> students;
    private List<JoinListener> joinListeners = new ArrayList<JoinListener>();

    public Klass(int number) {
        this.number = number;
        students = new ArrayList<Student>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student leader) {
        if (students == null || students.size() == 0) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = leader;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void appendMember(Student student) {
        students.add(student);
        notifyAllJoinListeners(student);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Klass) {
            return this.number == ((Klass) obj).getNumber();
        } else
            return false;
    }

    public boolean isIn(Student student) {
        boolean isIn = false;
        for (Student stu : students) {
            if (stu.equals(student))
                isIn = true;
        }
        return isIn;
    }

    public void attch(JoinListener joinListener) {
        joinListeners.add(joinListener);
    }

    public void notifyAllJoinListeners(Student student) {
        for (JoinListener joinListener : joinListeners) {
            joinListener.update(student);
        }
    }
}
