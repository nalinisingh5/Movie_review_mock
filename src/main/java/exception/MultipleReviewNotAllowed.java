package exception;

public class MultipleReviewNotAllowed extends RuntimeException {
  public MultipleReviewNotAllowed(String message) {
    super(message);
  }
}
