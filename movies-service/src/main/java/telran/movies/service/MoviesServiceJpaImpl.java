package telran.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import telran.movies.dto.*;
import telran.movies.entities.Cinema;
import telran.movies.entities.Movie;
import telran.movies.entities.Watch;
import telran.movies.repo.CinemaRepository;
import telran.movies.repo.MovieRepository;
import telran.movies.repo.WatchRepository;
import telran.movies.service.api.MoviesService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MoviesServiceJpaImpl implements MoviesService {
    @Autowired
    CinemaRepository cinemaRepo;
    @Autowired
    MovieRepository movieRepo;
    @Autowired
    WatchRepository watchRepo;

    @Override
    public void addMovie(MovieDto movieDto) {
        if (movieRepo.existsById(movieDto.name)) {
            throw new RuntimeException("Movie already exists " + movieDto.name);
        }
        Movie movie = toMovie(movieDto);
        movieRepo.save(movie);

    }

    private Movie toMovie(MovieDto movieDto) {

        return new Movie(movieDto.name, movieDto.producer, movieDto.year);
    }

    @Override
    public MovieDto getMovie(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MovieDto> getMoviesProducer(String producer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MovieDto> getMoviesYears(int yearFrom, int yearTo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteMovie(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<MovieDto> getMovies() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addCinema(CinemaDto cinemaDto) {
        if (cinemaRepo.existsById(cinemaDto.name)) {
            throw new RuntimeException("Cinema already exists " + cinemaDto.name);
        }
        Cinema cinema = toCinema(cinemaDto);
        cinemaRepo.save(cinema);

    }

    private Cinema toCinema(CinemaDto cinemaDto) {

        return new Cinema(cinemaDto.name, cinemaDto.city, cinemaDto.places);
    }

    @Override
    public void addWatch(WatchDto watchDto) {
        Cinema cinema = cinemaRepo.findById(watchDto.cinemaName).orElse(null);
        if (cinema == null) {
            throw new RuntimeException("no cinema " + watchDto.cinemaName);
        }
        Movie movie = movieRepo.findById(watchDto.movieName).orElse(null);
        if (movie == null) {
            throw new RuntimeException("no movie " + watchDto.movieName);
        }
        LocalDateTime dateTime = LocalDateTime.parse(watchDto.dateTime);

        Watch watch = new Watch(dateTime, watchDto.ticketCost, watchDto.tickets, cinema, movie);
        watchRepo.save(watch);

    }

    @Override
    public List<MovieDto> moviesWatchesGreaterThan(int nWatches) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MovieDto> mostPopularMovies(int amount) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CinemaDto> profitableCinemas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MovieDto> profitableMoviesCity(String city) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CinemaDto> cinemasLeastMovieWatchesProducer(int nCinemas, String producer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateProducer(String movieName, String producer) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<MovieCinemaTickets> getMoviesCinemasTickets() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CinemaProfit> getCinemasProfits() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteCinemasLessProfit(long profit) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updatePlaces(String cinemaName, int places) {
        // TODO Auto-generated method stub

    }

    @Override
    public CinemaDto getCinema(String cinemaName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CinemaDto> getCinemas() {
        // TODO Auto-generated method stub
        return null;
    }

}
