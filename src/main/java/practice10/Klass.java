package practice10;

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
        if (!isIn(leader)){
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = leader;
    }

    public void appendMember(Student student) {
        students.add(student);
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
}
