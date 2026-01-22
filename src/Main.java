import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CandidateDAO cDao = new CandidateDAO();
        QuestionDAO qDao = new QuestionDAO();

        Candidate c1 = new Candidate("Ali", 1);
        c1.setScore(10);
        cDao.insertCandidate(c1);

        Question q1 = new Question("2 + 2 = ?", "4", 10);
        qDao.insertQuestion(q1);

        System.out.println("\n--- ALL CANDIDATES ---");
        for (Candidate c : cDao.getAllCandidates()) {
            System.out.println(c);
        }

        System.out.println("\n--- ALL QUESTIONS ---");
        for (Question q : qDao.getAllQuestions()) {
            System.out.println(q.getText() + " | " + q.getCorrectAnswer() + " | " + q.getPoints());
        }

        cDao.updateScore(1, 50);
        qDao.updateQuestionPoints(1, 99);

        cDao.deleteCandidateById(2);
        qDao.deleteQuestionById(2);
    }
}