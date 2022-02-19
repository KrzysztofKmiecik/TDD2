package pl.kmiecik.tdd2.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kmiecik.tdd2.domain.Response;

public interface GreetingRepository extends JpaRepository<Response, Long> {
}
