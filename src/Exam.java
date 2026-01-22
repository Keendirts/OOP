public class Exam {

    private String subject;
    private Question question;
    private Candidate candidate;

    public Exam(String subject, Question question, Candidate candidate) {
        this.subject = subject;
        this.question = question;
        this.candidate = candidate;
    }

    public void startExam(String answer) {
        if (question.checkAnswer(answer)) {
            candidate.addScore(question.getPoints());
        }
    }
}