package com.bntsoft.controller;

import com.bntsoft.dto.IntArrayDTO;
import com.bntsoft.dto.ResponseDTO;
import com.bntsoft.service.CalculatorService;
import com.bntsoft.util.CalculatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("calculatorapi")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private CalculatorUtils calculatorUtils;

    @GetMapping(path="/v1/addition")
    public ResponseEntity<ResponseDTO> add(@RequestParam("number1") double number1,
                                           @RequestParam("number2") double number2){
        String answer = calculatorService.add(number1, number2);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAnswer(new BigDecimal(answer));
        responseDTO.setDetail(calculatorUtils.formatVal(number1)+"+"+calculatorUtils.formatVal(number2)+"="+answer);
        ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity(responseDTO, HttpStatus.OK);
        return responseEntity;
    }

   @GetMapping(path="/v1/substraction")
    public ResponseEntity substract(@RequestParam("number1") double number1,
                                   @RequestParam("number2") double number2){
       String answer = calculatorService.substract(number1, number2);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAnswer(new BigDecimal(answer));
        responseDTO.setDetail(calculatorUtils.formatVal(number1)+"-"+calculatorUtils.formatVal(number2)+"="+answer);
        ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity(responseDTO, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path="/v1/multiplication")
    public ResponseEntity multiply(@RequestParam("number1") double number1,
                                   @RequestParam("number2") double number2){
        String answer = calculatorService.multiply(number1, number2);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAnswer(new BigDecimal(answer));
        responseDTO.setDetail(calculatorUtils.formatVal(number1)+"*"+calculatorUtils.formatVal(number2)+"="+answer);
        ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity(responseDTO, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path="/v1/division")
    public ResponseEntity divide(@RequestParam("number1") double number1,
                                   @RequestParam("number2") double number2){
        String answer = calculatorService.divide(number1, number2);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAnswer( new BigDecimal(answer));
        responseDTO.setDetail(calculatorUtils.formatVal(number1)+"/"+calculatorUtils.formatVal(number2)+"="+answer);
        ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity(responseDTO, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path="/v1/square/{number}")
    public ResponseEntity square(@PathVariable("number") double number){
        String answer = calculatorService.square(number);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAnswer(new BigDecimal(answer));
        responseDTO.setDetail("square of " + calculatorUtils.formatVal(number) + " = " + answer);  //"square of 5 = 25
        ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity(responseDTO, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path="/v1/squareroot/{number}")
    public ResponseEntity squareroot(@PathVariable("number") double number){
        String squareroot = calculatorService.squareroot(number);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAnswer(new BigDecimal(squareroot));
        responseDTO.setDetail("squareroot of " + calculatorUtils.formatVal(number)+ " = " + squareroot);
        ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity(responseDTO, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path="/v1/factorial/{number}")
    public ResponseEntity factorial(@PathVariable("number") int number){
        int factorial = calculatorService.factorial(number);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setAnswer(new BigDecimal(factorial));
        responseDTO.setDetail(calculatorUtils.formatVal(number) + "! = " + factorial);
        ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity(responseDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(path="/v1/min-max")
    public ResponseEntity minmax(@RequestBody IntArrayDTO intArray){
        int[] inputData = intArray.getData();
        int[] minmax = calculatorService.minmax(inputData);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMin(minmax[0]);
        responseDTO.setMax(minmax[1]);
        ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity(responseDTO, HttpStatus.OK);
        return responseEntity;
    }


}
