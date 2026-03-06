import java.sql.*;
import db.DatabaseInitializer;

public class Login {
    /**
     * Funzione di Login
     */
    public boolean login(String identificativo, String password) {
        String query = "SELECT * FROM utenti WHERE (username = ? OR email = ?) AND password = ?";

        try (Connection conn = DriverManager.getConnection(DatabaseInitializer.DB_URL);
        		PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, identificativo);
            pstmt.setString(2, identificativo);
            pstmt.setString(3, password);

            try (ResultSet rs = pstmt.executeQuery()) {
            		// Ritorna true se trova una corrispondenza
                return rs.next(); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}