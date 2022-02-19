package pl.kmiecik.tdd2.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kmiecik.tdd2.application.port.GreetingService;
import pl.kmiecik.tdd2.domain.Response;
import pl.kmiecik.tdd2.infrastructure.GreetingRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
class GreetingServiceUseCase implements GreetingService {

    private final GreetingRepository greetingRepository;

    @Override
    public Response greet(String name, boolean isFormal) {
        return greetingRepository.save(new Response("Hello "+name,LocalDateTime.now()));
    }
}
