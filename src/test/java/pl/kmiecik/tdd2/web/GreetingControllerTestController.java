package pl.kmiecik.tdd2.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.kmiecik.tdd2.application.port.GreetingService;
import pl.kmiecik.tdd2.domain.Response;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class GreetingControllerTestController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GreetingService greetingService;

    @Test
    @DisplayName("")
    public void shouldGreet_200() throws Exception {
        Mockito.when(greetingService.greet("Kris", true)).thenReturn(new Response("Hello, Kris", LocalDateTime.now()));

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/greet")
                        .contentType("application/json")
                        .param("name", "Kris")
                        .param("isFormal", "true"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        //   .andExpect(MockMvcResultMatchers.jsonPath("$.greeting").value("Hello, Kris"));

        String jsonContent = resultActions.andReturn().getResponse().getContentAsString();
        Response response = objectMapper.readValue(jsonContent, Response.class);
        Assertions.assertEquals("Hello, Kris",response.getGreeting());


        // fail();
    }

}