package com.bntsoft.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(GreetController.class)
@AutoConfigureMockMvc(addFilters = false)
class GreetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGreetHelloWorld() throws Exception {
        String greetMessage = "Hello World!!";
       mockMvc.perform(get("/greetapi/v1/hello"))
                .andExpect(status().isOk())
               .andExpect(content().string(greetMessage));
    }

    @Test
    void testGreetHelloName() throws Exception {
        String greetMessage = "Hello Vishnu!!";
        String input = "Vishnu";
        mockMvc.perform(get("/greetapi/v1/hello")
                .param("name", input))
                .andExpect(status().isOk())
                .andExpect(content().string(greetMessage));
    }
}