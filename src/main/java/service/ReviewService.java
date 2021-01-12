package service;

import exception.MovieNotReleased;
import exception.UserNotFound;
import model.Genre;
import model.HighestRating;
import model.Movie;
import model.Review;
import model.ReviewCompare;
import model.User;
import repository.ReviewRepository;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReviewService {
  public void addReview(String user, String movieName, int rating) {
    if (validateUser(user)) {
      if (validateMovie(movieName)) {
        if (!ReviewRepository.userReviewList.containsKey(user)) {
          // Set user as Viewer
          UserService.setUserAsViewer(user);
          MovieService.addRatings(movieName, rating);
          Review review = new Review(MovieService.findMovieByName(movieName), rating);
          ReviewRepository.userReviewList.put(user, new ArrayList<>(Arrays.asList(review)));
        } else {
          if (ReviewRepository.userReviewList.get(user).size() >= 2) {
            // Set Viewer as Critic
            UserService.setUserAsCritic(user);
            MovieService.addRatings(movieName, rating * 2);
            ReviewRepository.userReviewList.put(
                user,
                new ArrayList<>(
                    Arrays.asList(
                        new Review(MovieService.findMovieByName(movieName), rating * 2))));
          } else MovieService.addRatings(movieName, rating);
          ReviewRepository.userReviewList.put(
              user,
              new ArrayList<>(
                  Arrays.asList(new Review(MovieService.findMovieByName(movieName), rating))));
        }
      } else throw new MovieNotReleased("Movie: %s not yet released", movieName);
    } else throw new UserNotFound("User: %s not found, please register ", user);
  }

  private boolean validateMovie(String movieName) {
    Movie movie = MovieService.findMovieByName(movieName);
    return movie.getYear().compareTo(Year.now()) == 1 ? false : true;
  }

  private boolean validateUser(String viewer) {
    User user = UserService.findUserByName(viewer);
    return user != null;
  }

  public HighestRating topMovieByYear(Year year) {
    List<Review> reviewList =
        ReviewRepository.userReviewList.entrySet().stream()
            .map(m -> m.getValue())
            .flatMap(List::stream)
            .collect(Collectors.toList())
            .stream()
            .filter(review -> review.getMovie().getYear().equals(year))
            .collect(Collectors.toList());
    ReviewCompare reviewCompare = new ReviewCompare();
    Collections.sort(reviewList, reviewCompare);

    Review review = reviewList.stream().findFirst().orElseThrow();
    HighestRating highestRating = new HighestRating(review.getMovie().getRating(), review);
    return highestRating;
  }

  public HighestRating topMovieByGenre(Genre drama) {
    List<Review> reviewList =
        ReviewRepository.userReviewList.entrySet().stream()
            .map(m -> m.getValue())
            .flatMap(List::stream)
            .collect(Collectors.toList())
            .stream()
            .filter(review -> review.getMovie().getGenres().contains(drama))
            .collect(Collectors.toList());
    ReviewCompare reviewCompare = new ReviewCompare();
    Collections.sort(reviewList, reviewCompare);

    Review review = reviewList.stream().findFirst().orElseThrow();
    HighestRating highestRating = new HighestRating(review.getMovie().getRating(), review);
    return highestRating;
  }
}
