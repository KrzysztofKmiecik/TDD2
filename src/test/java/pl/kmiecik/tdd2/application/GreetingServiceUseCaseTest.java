package pl.kmiecik.tdd2.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kmiecik.tdd2.domain.Response;
import pl.kmiecik.tdd2.infrastructure.GreetingRepository;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.argThat;

@ExtendWith(MockitoExtension.class)
class GreetingServiceUseCaseTest {
    @Mock
    private GreetingRepository greetingRepository;

    @InjectMocks
    private GreetingServiceUseCase greetingServiceUseCase;


    @Test
    @DisplayName(" aa")
    public void shouldGreetWithHello() {
        //given
        String expected = "Hello Kris";
        Response stubbedResponse = new Response(expected, LocalDateTime.now());
        //when
        Mockito.when(greetingRepository.save(argThat(response -> expected.equals(response.getGreeting())))).thenReturn(stubbedResponse);
        //then
        Response response = greetingServiceUseCase.greet("Kris", true);
        String currentValue = response.getGreeting();

        Assertions.assertEquals(expected, currentValue);

    }

    @Test
    @DisplayName("")
    public void shouldGetHelloKris(){
        //given
        String expected="Hello Kris";
        //when
        Response stubbedResponse=new Response("Hello Kris",LocalDateTime.now());
        Mockito.when(greetingRepository.save(argThat(response -> expected.equals(response.getGreeting())))).thenReturn(stubbedResponse);
        //then
        Response response = greetingServiceUseCase.greet("Kris", true);
        String actualValue=response.getGreeting();
        Assertions.assertEquals(expected,actualValue);

    }

}