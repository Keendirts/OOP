public class Main {

    public static void main(String[] args) {

        Question q1 = new Question("2 + 2 = ?", "4", 10);

        Candidate c1 = new Candidate("Ali", 1);
        Candidate c2 = new Candidate("Aruzhan", 2);

        Exam exam1 = new Exam("Math", q1, c1);
        Exam exam2 = new Exam("Math", q1, c2);

        exam1.startExam("4");
        exam2.startExam("3");

        System.out.println(c1.getName() + " score: " + c1.getScore());
        System.out.println(c2.getName() + " score: " + c2.getScore());

        System.out.println("Better result: " +
                (c1.getScore() > c2.getScore() ? c1.getName() : c2.getName()));
    }
}