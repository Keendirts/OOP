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
        return correctAnswer != null && correctAnswer.trim().equalsIgnoreCase(answer.trim());
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
}