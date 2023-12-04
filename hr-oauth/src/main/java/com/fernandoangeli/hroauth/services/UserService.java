package com.fernandoangeli.hroauth.services;

import com.fernandoangeli.hroauth.domains.User;
import com.fernandoangeli.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            logger.error("E-mail not found: " + email);
            throw new IllegalArgumentException("E-mail not found");
        }
        logger.info("E-mail found: " + email);
        return user;
    }

}
