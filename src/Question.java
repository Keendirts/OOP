import java.util.Objects;

public class Question {

    private String text;
    private String correctAnswer;
    private int points;

    public Question(String text, String correctAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public boolean checkAnswer(String answer) {
        if (answer == null) return false;
        if (correctAnswer == null) return false;
        return correctAnswer.trim().equalsIgnoreCase(answer.trim());
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getPoints() {
        return points;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Question{text='" + text + "', points=" + points + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return Objects.equals(text, question.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}