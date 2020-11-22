package telran.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.movies.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {

}
