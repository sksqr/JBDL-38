package com.gfg.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    @Autowired
    private SMSGateway smsGateway;

//    public NotificationService(SMSGateway smsGateway) {
//        this.smsGateway = smsGateway;
//    }

    public void sendNotification(String data){
        smsGateway.sendSMS(data);
    }
}
