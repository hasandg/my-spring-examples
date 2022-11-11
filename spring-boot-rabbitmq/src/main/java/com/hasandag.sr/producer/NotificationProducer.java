package com.hasandag.sr.producer;

import com.hasandag.sr.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Value("${sr.rabbit.exchange.name}")
    private String exchageName;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        com.hasandag.sr.model.Notification notification = new com.hasandag.sr.model.Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreateAt(new Date());
        notification.setMessage("Hasan DAG new Message");
        notification.setSeen(Boolean.FALSE);

        sendToQueue(notification);
    }


    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent " + notification.toString());
        rabbitTemplate.convertAndSend(exchageName,routingName, notification);
    }
}
