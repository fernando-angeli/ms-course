package com.fernandoangeli.hrworker.controllers;

import com.fernandoangeli.hrworker.domains.Worker;
import com.fernandoangeli.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){


        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker worker = repository.findById(id).get();
        return ResponseEntity.ok().body(worker);
    }

    @GetMapping("/configs")
    public ResponseEntity<String> getConfigs(){
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.ok("CONFIG = " + testConfig);
    }

}
