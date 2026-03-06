import java.sql.*;

public class DatabaseInitializer {
    public static final String DB_URL = "jdbc:sqlite:User_Data.db";

    public static void initialize() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                System.out.println("Database connection established (file created if not exists)");
            }
        } catch (SQLException e) {
            System.err.println("Error during database connection:");
            e.printStackTrace();
        }
    }
}