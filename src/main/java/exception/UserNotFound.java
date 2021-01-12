package exception;

public class UserNotFound extends RuntimeException {
  public UserNotFound(String s, String message) {
    super(message);
  }
}
