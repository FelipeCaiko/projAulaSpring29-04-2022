package br.com.projAulaSpring.rabbit;

import br.com.projAulaSpring.model.Client;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Client client){
        rabbitTemplate.convertAndSend(this.queue.getName(), client);
    }
}