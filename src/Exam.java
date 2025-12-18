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

    public String getSubject() {
        return subject;
    }

    public Question getQuestion() {
        return question;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}