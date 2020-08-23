package pl.adcom.sbclientrabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientMq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/receiveMessage")
    public String getMessage(){
        Object message = rabbitTemplate.receiveAndConvert("eggs");
        return message.toString();
    }
}
