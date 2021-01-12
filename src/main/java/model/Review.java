package model;

public class Review {

  private Movie movie;
  private Integer rating;

  public Review(Movie movie, Integer rating) {
    this.movie = movie;
    this.rating = rating;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }
}
