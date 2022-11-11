package com.hasandag.sr.listener;

import com.hasandag.sr.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "${sr.rabbit.queue.name}")
    public void handleMessage(Notification notification){
        System.out.println("Message Received...!");

        System.out.println(notification.toString());
    }
}
