package service;

import model.Genre;
import model.Movie;
import repository.MovieRepository;

import java.time.Year;
import java.util.List;

public class MovieService {
  public static Movie findMovieByName(String movieName) {
    return MovieRepository.movieSet.stream()
        .filter(movie -> movie.getMovieName().equals(movieName))
        .findFirst()
        .orElseThrow();
  }

  public static void addRatings(String movieName, int rating) {
    Movie movie = findMovieByName(movieName);
    movie.setRating(movie.getRating() + rating);
    MovieRepository.movieSet.add(movie);
  }

  public Movie addMovie(String movieName, Year releaseYear, List<Genre> genres) {
    Movie movie = new Movie(movieName, releaseYear, genres);
    MovieRepository.movieSet.add(movie);
    return movie;
  }
}
