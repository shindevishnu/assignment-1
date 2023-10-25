package com.bntsoft.util;

import org.springframework.stereotype.Component;

@Component
public class CalculatorUtils {

   /* public <T> T formatVal(double value){
        if (value == (int) value) {
           return  (T) Integer.valueOf((int) value);
        } else {
           return (T) Double.valueOf(value);
        }
    }*/

    public String formatVal(double value){
        if (value == (int) value) {
            return  String.valueOf((int) value);
        } else {
            return String.valueOf(value);
        }
    }

    public  int calculateFactorial(int num) {
        if (num == 0 || num ==1){
            return 1;
        }
        return num * calculateFactorial(num -1);

    }
}
