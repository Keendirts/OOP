public class Candidate {

    private int id;
    private String name;
    private int score;

    public Candidate(String name, int id) {
        this.name = name;
        this.id = id;
        this.score = 0;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Candidate{id=" + id + ", name='" + name + "', score=" + score + "}";
    }
}