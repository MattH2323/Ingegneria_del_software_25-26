import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class removeUser implements removeUserService {
	
	private Connection connection;
	
	public removeUser(Connection connection) {
		this.connection = connection;
		
	}
	
	@Override
	public boolean removeByUserEmail(String userEmail) {
		String sql = "DELETE FROM utenti WHERE email = ?";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, userEmail);
			int affectedRows = pstmt.executeUpdate();
			handleResponse(affectedRows, userEmail);
			return affectedRows > 0;
		} catch (SQLException e) {
			System.err.println("Errore durante la rimozione tramite email: " + e.getMessage());
			return false;
		}
	}
	
	@Override
	public boolean removeByUserId(int userId) {
		String sql = "DELETE FROM utenti WHERE id = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			int affectedRows = pstmt.executeUpdate();
			handleResponse(affectedRows, String.valueOf(userId));
			return affectedRows > 0;
		} catch (SQLException e) {
			System.err.println("Errore durante la rimozione: " + e.getMessage());
			return false;
		}
	}
	
	private void handleResponse(int rows, String identifier) {
		if (rows > 0) {
			System.out.println("Rimozione avvenuta con successo per: " + identifier);
		} else {
			System.out.println("Nessun utente trovato con il parametro: " + identifier);
		}
	}
}
