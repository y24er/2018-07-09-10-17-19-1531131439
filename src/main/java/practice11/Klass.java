package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<JoinListener> joinListeners = new ArrayList<JoinListener>();
    private List<LeaderListener> leaderListeners = new ArrayList<LeaderListener>();

    public Klass(int number) {
        this.number = number;
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
        if (!isIn(leader)) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = leader;
        notifyAllLeaderListeners(leader);
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        notifyAllJoinListeners(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number;
    }

    public boolean isIn(Student student) {
        return student.getKlass().equals(this);
    }

    public void attachJoinListener(JoinListener joinListener) {
        joinListeners.add(joinListener);
    }

    public void notifyAllJoinListeners(Student student) {
        for (JoinListener joinListener : joinListeners) {
            joinListener.joinUpdate(student);
        }
    }

    public void attachLeaderListener(LeaderListener leaderListener) {
        leaderListeners.add(leaderListener);
    }

    public void notifyAllLeaderListeners(Student leader) {
        for (LeaderListener leaderListener : leaderListeners) {
            leaderListener.leaderUpdate(leader);

        }
    }
}
