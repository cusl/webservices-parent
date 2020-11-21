package telran.movies.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import telran.movies.dto.CinemaDto;
import telran.movies.dto.MovieDto;
import telran.movies.dto.WatchDto;
import telran.movies.service.api.MoviesService;

@RestController
public class MoviesRestController {
    static Logger LOG = LoggerFactory.getLogger(MoviesRestController.class);
    @Autowired
    MoviesService service;

    @PostMapping("movies")
    MovieDto addMovie(@RequestBody MovieDto movie) {
        service.addMovie(movie);
        LOG.debug("movie {} added", movie.name);
        return movie;
    }

    @PostMapping("movies/cinema")
    CinemaDto addCinema(@RequestBody CinemaDto cinema) {
        service.addCinema(cinema);
        LOG.debug("cinema {} added", cinema.name);
        return cinema;
    }

    @PostMapping("movies/watch")
    WatchDto addWatch(@RequestBody WatchDto watch) {
        service.addWatch(watch);
        LOG.debug("watch of movie {} in cinema {} added", watch.movieName, watch.cinemaName);
        return watch;
    }
}
