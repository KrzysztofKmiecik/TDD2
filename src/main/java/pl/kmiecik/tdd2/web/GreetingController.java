package pl.kmiecik.tdd2.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kmiecik.tdd2.application.port.GreetingService;
import pl.kmiecik.tdd2.domain.Response;

@RestController
@AllArgsConstructor
class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/greet")
    public Response greet(@RequestParam String name, @RequestParam boolean isFormal){
        return greetingService.greet(name,isFormal);
    }
}
