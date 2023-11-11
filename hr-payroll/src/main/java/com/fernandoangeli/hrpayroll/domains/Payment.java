package com.fernandoangeli.hrpayroll.domains;

import lombok.*;

@Data
@AllArgsConstructor
public class Payment {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getTotal(){
        return days * dailyIncome;
    }

}
