import java.sql.*;
import java.util.ArrayList;

public class QuestionDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/OOP";
    private static final String USER = "postgres";
    private static final String PASSWORD = "724056";

    public void insertQuestion(Question q) {
        String sql = "INSERT INTO question(text, correct_answer, points) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, q.getText());
            ps.setString(2, q.getCorrectAnswer());
            ps.setInt(3, q.getPoints());
            ps.executeUpdate();

            System.out.println("Question inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> list = new ArrayList<>();
        String sql = "SELECT text, correct_answer, points FROM question ORDER BY id";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Question(
                        rs.getString("text"),
                        rs.getString("correct_answer"),
                        rs.getInt("points")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateQuestionPoints(int id, int newPoints) {
        String sql = "UPDATE question SET points = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newPoints);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Question updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteQuestionById(int id) {
        String sql = "DELETE FROM question WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Question deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}