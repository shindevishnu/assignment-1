package com.bntsoft.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseDTO {
    private BigDecimal answer;
    private String detail;
    private int min;
    private int max;

    public ResponseDTO() {
    }

    public ResponseDTO(BigDecimal answer, String detail) {
        this.answer = answer;
        this.detail = detail;
    }

    public BigDecimal getAnswer() {
        return answer;
    }

    public void setAnswer(BigDecimal answer) {
        this.answer = answer;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "answer=" + answer +
                ", detail='" + detail + '\'' +
                '}';
    }
}
