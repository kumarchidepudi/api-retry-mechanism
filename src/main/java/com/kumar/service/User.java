package com.kumar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service(value = "user")
public class User {
    private static final Logger log = LoggerFactory.getLogger(User.class);
    static int maxRetries = 3;
    static boolean lastCallSuccessful = false;
    static boolean currentCallSuccessful;
    final CallingService service;

    public User(CallingService service) {
        this.service = service;
    }

    public void initiateCall(){
        Map<Boolean,String> response=new HashMap<>();
        for (int i = 0; i <= maxRetries; i++) {
            response = service.callService();
            currentCallSuccessful=response.keySet().iterator().next();
            if(!currentCallSuccessful){
                if(!lastCallSuccessful){
                    log.error("Retry mechanism is not applicable as last call was also a failed one");
                    throw new RuntimeException("Location service is not responding");
                }
            }
            if (currentCallSuccessful) {
                System.out.println("Call succeeded on attempt " + i);
                System.out.println("Response got from the service is "+response.get(true));
                break;
            }else if (i == maxRetries) {
                System.out.println("Call failed after " + maxRetries + " attempts.");
                lastCallSuccessful=currentCallSuccessful;
                throw new RuntimeException("Location service is not responding");
            }
        }
        lastCallSuccessful=currentCallSuccessful;
        if(currentCallSuccessful&&response.get(true)!=null){
            proceed(response.get(true));
        }
    }

    private void proceed(String s) {
        System.out.println("processed the response further "+s);
    }
}
