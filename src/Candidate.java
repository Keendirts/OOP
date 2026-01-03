import java.util.Objects;

public class Candidate extends Person {

    private int score;

    public Candidate(String name, int id) {
        super(name, id);
        this.score = 0;
    }

    @Override
    public String getRole() {
        return "Candidate";
    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Candidate{id=" + getId() + ", name='" + getName() + "', score=" + score + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate)) return false;
        Candidate that = (Candidate) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}