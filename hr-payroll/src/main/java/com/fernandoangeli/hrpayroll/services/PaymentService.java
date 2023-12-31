package com.fernandoangeli.hrpayroll.services;

import com.fernandoangeli.hrpayroll.domains.Payment;
import com.fernandoangeli.hrpayroll.domains.Worker;
import com.fernandoangeli.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }


    /*
    > Método para uso do RestTemplate
    public Payment getPayment(long workerId, int days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}", Worker.class, uriVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
     */

}
