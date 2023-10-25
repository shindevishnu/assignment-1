package com.bntsoft.controller;

import com.bntsoft.dto.IntArrayDTO;
import com.bntsoft.service.CalculatorService;
import com.bntsoft.util.CalculatorUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CalculatorController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @MockBean
    private CalculatorUtils calculatorUtils;



    @Test
    public void testAdd()throws Exception{
        double number1 = 10;
        double number2 = 20;
        String expectedAnswer = "30";
        String jsonResponse = "{\"answer\":30,\"detail\":\"10+20=30\"}";

        Mockito.when(calculatorService.add(number1, number2)).thenReturn(expectedAnswer);
        Mockito.when(calculatorUtils.formatVal(number1)).thenReturn("10");
        Mockito.when(calculatorUtils.formatVal(number2)).thenReturn("20");
        mockMvc.perform(get("/calculatorapi/v1/addition")
                        .param("number1", String.valueOf(number1))
                        .param("number2", String.valueOf(number2))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }

   @Test
    public void testSubstract()throws Exception{
        double number1 = 20;
        double number2 = 10;
        String expectedAnswer = "10";
        double result = 10;
        String jsonResponse = "{\"answer\":10,\"detail\":\"20-10=10\"}";

        Mockito.when(calculatorService.substract(number1, number2)).thenReturn(expectedAnswer);
       Mockito.when(calculatorUtils.formatVal(number1)).thenReturn("20");
       Mockito.when(calculatorUtils.formatVal(number2)).thenReturn("10");
        mockMvc.perform(get("/calculatorapi/v1/substraction")
                        .param("number1", String.valueOf(number1))
                        .param("number2", String.valueOf(number2))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }



    @Test
    public void testMultiply() throws Exception{
        int number1 = 25;
        int number2 = 13;
        String expectedAnswer = "200";
        String jsonResponse = "{\"answer\":200,\"detail\":\"25*13=200\"}";
        Mockito.when(calculatorService.multiply(number1, number2)).thenReturn(expectedAnswer);
        Mockito.when(calculatorUtils.formatVal(number1)).thenReturn("25");
        Mockito.when(calculatorUtils.formatVal(number2)).thenReturn("13");
        mockMvc.perform(get("/calculatorapi/v1/multiplication")
                .param("number1", String.valueOf(number1))
                .param("number2", String.valueOf(number2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }

    @Test
   public void testDivision() throws Exception{
        double number1 = 20;
        double number2 = 10;
        String expectedAnswer = "2";
        String jsonResponse ="{\"answer\":2,\"detail\":\"20/10=2\"}";
        Mockito.when(calculatorService.divide(number1, number2)).thenReturn(expectedAnswer);
        Mockito.when(calculatorUtils.formatVal(number1)).thenReturn("20");
        Mockito.when(calculatorUtils.formatVal(number2)).thenReturn("10");
        mockMvc.perform(get("/calculatorapi/v1/division")
                        .param("number1", String.valueOf(number1))
                        .param("number2", String.valueOf(number2))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void testSquare()throws Exception{
        double number1 = 10;
        String expectedAnswer = "100";
        String jsonResponse = " { \"answer\": 100, \"detail\": \"square of 10 = 100\" }";

        Mockito.when(calculatorService.square(number1)).thenReturn(expectedAnswer);
        Mockito.when(calculatorUtils.formatVal(number1)).thenReturn("10");
        mockMvc.perform(get("/calculatorapi/v1/square/{number}", number1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void testSquareRoot()throws Exception{
        double number1 = 100;
        String expectedAnswer = "10";
        String jsonResponse = " { \"answer\": 10, \"detail\": \"squareroot of 100 = 10\" }";

        Mockito.when(calculatorService.squareroot(number1)).thenReturn(expectedAnswer);
        Mockito.when(calculatorUtils.formatVal(number1)).thenReturn("100");
        mockMvc.perform(get("/calculatorapi/v1/squareroot/{number}", number1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void testFactorial()throws Exception{
        int number1 = 5;
        int expectedAnswer = 120;
        String jsonResponse = "{ \"answer\": 120, \"detail\": \"5! = 120\" }";

        Mockito.when(calculatorService.factorial(number1)).thenReturn(expectedAnswer);
        Mockito.when(calculatorUtils.formatVal(number1)).thenReturn("5");
        mockMvc.perform(get("/calculatorapi/v1/factorial/{number}", number1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void testMinMax()throws Exception{
        IntArrayDTO intArray = new IntArrayDTO();
        intArray.setData(new int[] {1, 2, 3, 4, 5});
        int[] minmax = new int[]{1, 5};
        Mockito.when(calculatorService.minmax(intArray.getData())).thenReturn(minmax);
        mockMvc.perform(post("/calculatorapi/v1/min-max")
                        .content(asJsonString(intArray))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.min").value(1))
                .andExpect(jsonPath("$.max").value(5));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }









}
