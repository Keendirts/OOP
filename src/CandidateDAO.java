import java.sql.*;
import java.util.ArrayList;

public class CandidateDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/OOP";
    private static final String USER = "postgres";
    private static final String PASSWORD = "724056";

    public void insertCandidate(Candidate c) {
        String sql = "INSERT INTO candidate(name, score) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getName());
            ps.setInt(2, c.getScore());
            ps.executeUpdate();

            System.out.println("Candidate inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Candidate> getAllCandidates() {
        ArrayList<Candidate> list = new ArrayList<>();
        String sql = "SELECT id, name, score FROM candidate ORDER BY id";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Candidate c = new Candidate(
                        rs.getString("name"),
                        rs.getInt("id")
                );
                c.setScore(rs.getInt("score"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateScore(int id, int newScore) {
        String sql = "UPDATE candidate SET score = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newScore);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Score updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCandidateById(int id) {
        String sql = "DELETE FROM candidate WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Candidate deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}