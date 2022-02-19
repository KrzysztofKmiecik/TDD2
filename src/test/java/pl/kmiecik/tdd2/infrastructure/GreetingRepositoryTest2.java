package pl.kmiecik.tdd2.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import pl.kmiecik.tdd2.domain.Response;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.annotation.DirtiesContext.*;

@DataJpaTest
@DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
class GreetingRepositoryTest2 {


    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    @DisplayName("")
    public void shouldSaveResponsewithID1(){
        assertTrue(greetingRepository.findAll().isEmpty());
        Response savedResponse = greetingRepository.save(new Response("Hello Kris", LocalDateTime.now()));

        assertAll(
                ()->assertEquals(1,greetingRepository.findAll().size()),
                ()->assertEquals(savedResponse.getId(),greetingRepository.findById(1L).get().getId()),
                ()->assertEquals(savedResponse.getGreeting(),greetingRepository.findById(1L).get().getGreeting())

        );
    }
}