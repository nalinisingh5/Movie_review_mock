package exception;

public class MovieNotReleased extends RuntimeException {
  public MovieNotReleased(String s, String message) {
    super(message);
  }
}
