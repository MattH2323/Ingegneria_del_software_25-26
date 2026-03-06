package RemoveUserService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveUserTest {

    private Connection mockConnection;
    private PreparedStatement mockStatement;
    private removeUser service;

    @BeforeEach
    void setUp() throws SQLException {
        // Creiamo i "finti" oggetti del database
        mockConnection = mock(Connection.class);
        mockStatement = mock(PreparedStatement.class);
        
        // Diciamo alla connessione di restituire il finto statement quando viene chiamata prepareStatement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        
        // Inizializziamo la classe da testare con la connessione fasulla
        service = new removeUser(mockConnection);
    }

    @Test
    void testRemoveByUserId_Success() throws SQLException {
        // Simuliamo che il database trovi e cancelli 1 riga
        when(mockStatement.executeUpdate()).thenReturn(1);

        boolean result = service.removeByUserId(10);

        assertTrue(result, "Dovrebbe restituire true se una riga viene cancellata");
        verify(mockStatement).setInt(1, 10); // Verifichiamo che abbia passato l'ID corretto
        verify(mockStatement).executeUpdate(); // Verifichiamo che il comando sia stato lanciato
    }

    @Test
    void testRemoveByUserId_NotFound() throws SQLException {
        // Simuliamo che il database non trovi nulla (0 righe cancellate)
        when(mockStatement.executeUpdate()).thenReturn(0);

        boolean result = service.removeByUserId(999);

        assertFalse(result, "Dovrebbe restituire false se l'utente non esiste");
    }

    @Test
    void testRemoveByUserEmail_Success() throws SQLException {
        when(mockStatement.executeUpdate()).thenReturn(1);

        boolean result = service.removeByUserEmail("test@example.com");

        assertTrue(result);
        verify(mockStatement).setString(1, "test@example.com");
    }

    @Test
    void testRemove_SQLException() throws SQLException {
        // Simuliamo un errore improvviso del database (es. connessione persa)
        when(mockStatement.executeUpdate()).thenThrow(new SQLException("Database offline"));

        boolean result = service.removeByUserId(1);

        assertFalse(result, "Dovrebbe gestire l'eccezione e restituire false");
    }
}