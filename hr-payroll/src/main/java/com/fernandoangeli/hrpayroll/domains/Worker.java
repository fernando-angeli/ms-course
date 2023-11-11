package com.fernandoangeli.hrpayroll.domains;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

    private Long id;
    private String name;
    private Double dailyIncome;

}
