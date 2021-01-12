import exception.MovieNotReleased;
import exception.MultipleReviewNotAllowed;
import model.Genre;
import model.HighestRating;
import model.Movie;
import model.Review;
import model.User;
import service.MovieService;
import service.ReviewService;
import service.UserService;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieReview {

  static UserService userService;
  static MovieService movieService;
  static ReviewService reviewService;

  public static void main(String args[]) throws MultipleReviewNotAllowed, MovieNotReleased {
    userService = new UserService();
    movieService = new MovieService();
    reviewService = new ReviewService();

    // Create Users aka Viewers
    createUsers();

    // Add Movies
    addMovies();

    // Add reviews
    addAllreviews();

    // List Top 1 Movie in Year : 2017
    HighestRating ratingByYear = reviewService.topMovieByYear(Year.of(2017));
    System.out.println(
        ratingByYear.getReview().getMovie().getMovieName()
            + " released in the Year : "
            + ratingByYear.getReview().getMovie().getYear()
            + " has highest rating: "
            + ratingByYear.getRating());

    // List Top 1 Movie By Genre : Drama
    // List Top 1 Movie in Year : 2017
    HighestRating ratingByGenre = reviewService.topMovieByGenre(Genre.Drama);
    System.out.println(
        ratingByGenre.getReview().getMovie().getMovieName()
            + " released in the Year : "
            + ratingByGenre.getReview().getMovie().getYear()
            + " has highest rating: "
            + ratingByGenre.getRating()
            + " in Genre : "
            + Genre.Drama);
  }

  private static void addAllreviews() {
    reviewService.addReview("Nalini", "Don", 6);
    reviewService.addReview("Nalini", "Tiger", 6);
    reviewService.addReview("Richa", "Don", 4);
    reviewService.addReview("Rounak", "Lunchbox", 7);
    reviewService.addReview("Nalini", "Don", 10);
    reviewService.addReview("Richa", "Padmaavat", 4);
    reviewService.addReview("Nalini", "Lunchbox", 8);
    // reviewService.addReview("Nalini", "Wonder Woman", 9);
    // reviewService.addReview("Rounak", "Wonder Woman", 9);
    reviewService.addReview("Rounak", "Padmaavat", 4);
    reviewService.addReview("Richa", "Padmaavat", 5);
    // reviewService.addReview("Akhil", "Padmaavat", 4);
  }

  private static void addMovies() {
    Movie Don =
        movieService.addMovie(
            "Don", Year.of(2006), new ArrayList<>(Arrays.asList(Genre.Action, Genre.Thriller)));
    Movie Tiger =
        movieService.addMovie("Tiger", Year.of(2013), new ArrayList<>(Arrays.asList(Genre.Drama)));
    Movie Padmaavat =
        movieService.addMovie(
            "Padmaavat", Year.of(2017), new ArrayList<>(Arrays.asList(Genre.Drama)));
    Movie Lunchbox =
        movieService.addMovie(
            "Lunchbox", Year.of(2017), new ArrayList<>(Arrays.asList(Genre.Comedy, Genre.Romance)));
    Movie WonderWoman =
        movieService.addMovie(
            "Wonder Woman",
            Year.of(2022),
            new ArrayList<>(Arrays.asList(Genre.Action, Genre.SciFi)));
  }

  private static void createUsers() {
    User user1 = userService.createUser("Nalini", "nalinisingh.529@gmail.com", "8123813536");
    User user2 = userService.createUser("Richa", "richa.7@gmail.com", "5326965891");
    User user3 = userService.createUser("Rounak", "rounak.4@gmail.com", "2525341412");
  }
}
