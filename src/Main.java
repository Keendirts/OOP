import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("2 + 2 = ?", "4", 10));
        questions.add(new Question("5 + 5 = ?", "10", 15));

        ArrayList<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Ali", 1));
        candidates.add(new Candidate("Aruzhan", 2));

        ArrayList<Person> people = new ArrayList<>();
        people.addAll(candidates);

        Scanner scanner = new Scanner(System.in);

        System.out.println("People (polymorphism demo):");
        for (Person p : people) {
            System.out.println(p.getRole() + " -> " + p.getName() + " (id=" + p.getId() + ")");
        }

        System.out.print("Enter candidate name to search: ");
        String searchName = scanner.nextLine();

        Candidate found = null;
        for (Candidate c : candidates) {
            if (c.getName().equalsIgnoreCase(searchName.trim())) {
                found = c;
                break;
            }
        }

        if (found == null) {
            System.out.println("Candidate not found.");
            return;
        }

        System.out.println("Found: " + found);

        Question q = questions.get(0);
        Exam exam = new Exam("Math", q, found);

        System.out.println("Subject: " + exam.getSubject());
        System.out.println("Question: " + q.getText());
        System.out.print("Enter your answer: ");
        String answer = scanner.nextLine();

        exam.startExam(answer);

        System.out.println("Result: " + found);

        System.out.println("Filtered (score > 0):");
        for (Candidate c : candidates) {
            if (c.getScore() > 0) {
                System.out.println(c);
            }
        }

        Collections.sort(candidates, (a, b) -> Integer.compare(b.getScore(), a.getScore()));
        System.out.println("Sorted by score (desc):");
        for (Candidate c : candidates) {
            System.out.println(c);
        }
    }
}