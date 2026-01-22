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
        return correctAnswer.equalsIgnoreCase(answer);
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
}