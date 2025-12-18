public class Candidate {

    private String name;
    private int id;
    private int score;

    public Candidate(String name, int id) {
        this.name = name;
        this.id = id;
        this.score = 0;
    }

    public void addScore(int points) {
        score += points;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }
}