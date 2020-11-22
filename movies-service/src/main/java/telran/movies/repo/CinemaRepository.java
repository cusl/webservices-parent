package telran.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.movies.entities.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, String> {

}
