package pl.kmiecik.tdd2.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import pl.kmiecik.tdd2.domain.Response;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
class GreetingRepositoryTest {

    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    @DisplayName("")
    public void shouldSaveResponseWithID1(){
        assertTrue(greetingRepository.findAll().isEmpty());
        Response savedResponse = greetingRepository.save(new Response("Hello Kris", LocalDateTime.now()));

        assertAll(
                ()->assertEquals(1,greetingRepository.findAll().size()),
                ()->assertEquals(savedResponse.getId(),greetingRepository.findById(1L).get().getId()),
                ()->assertEquals(savedResponse.getGreeting(),greetingRepository.findById(1L).get().getGreeting())
        );

    }

}