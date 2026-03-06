import java.util.IllformedLocaleException;

public class ExistingUserException extends IllformedLocaleException {

    public ExistingUserException (String message) {
        super(message);
    }
}
