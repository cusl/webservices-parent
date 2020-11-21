package telran.movies.service.api;

import telran.movies.dto.*;

import java.util.List;


public interface MoviesService {
    void addMovie(MovieDto movieDto);

    MovieDto getMovie(String name);

    List<MovieDto> getMoviesProducer(String producer);

    List<MovieDto> getMoviesYears(int yearFrom, int yearTo);

    void deleteMovie(String name);

    List<MovieDto> getMovies();

    void addCinema(CinemaDto cinemaDto);

    void addWatch(WatchDto watchDto);

    List<MovieDto> moviesWatchesGreaterThan(int nWatches);

    List<MovieDto> mostPopularMovies(int amount);

    List<CinemaDto> profitableCinemas();

    List<MovieDto> profitableMoviesCity(String city);

    List<CinemaDto> cinemasLeastMovieWatchesProducer(int nCinemas, String producer);

    void updateProducer(String movieName, String producer);

    List<MovieCinemaTickets> getMoviesCinemasTickets();

    List<CinemaProfit> getCinemasProfits();

    void deleteCinemasLessProfit(long profit);

    void updatePlaces(String cinemaName, int places);

    CinemaDto getCinema(String cinemaName);

    List<CinemaDto> getCinemas();

}
