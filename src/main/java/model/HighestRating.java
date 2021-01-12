package model;

public class HighestRating {
  private Integer rating;
  private Review review;

  public HighestRating(Integer rating, Review review) {
    this.rating = rating;
    this.review = review;
  }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
