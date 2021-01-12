package model;

import java.time.Year;
import java.util.List;

public class Movie {
  private String movieName;
  private Year year;
  private List<Genre> genres;
  private Integer rating;

  public Movie(String movieName, Year year, List<Genre> genres) {
    this.movieName = movieName;
    this.year = year;
    this.genres = genres;
    rating = 0;
  }

  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public Year getYear() {
    return year;
  }

  public void setYear(Year year) {
    this.year = year;
  }

  public List<Genre> getGenres() {
    return genres;
  }

  public void setGenres(List<Genre> genres) {
    this.genres = genres;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }
}
