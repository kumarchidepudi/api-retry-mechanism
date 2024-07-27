package com.kumar.web;

import com.kumar.service.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final User user;

    public UserController(User user) {
        this.user = user;
    }

    @GetMapping()
    public void initiateCall(){
        try{
            user.initiateCall();
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        log.info("Call was completed");
    }
}
