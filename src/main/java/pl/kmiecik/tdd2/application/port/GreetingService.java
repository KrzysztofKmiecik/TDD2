package pl.kmiecik.tdd2.application.port;

import pl.kmiecik.tdd2.domain.Response;

public interface GreetingService {
    Response greet(String name,boolean isFormal);
}
