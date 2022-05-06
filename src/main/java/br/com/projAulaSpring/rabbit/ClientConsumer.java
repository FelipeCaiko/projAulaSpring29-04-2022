package br.com.projAulaSpring.rabbit;

import br.com.projAulaSpring.model.Client;
import br.com.projAulaSpring.service.ClientService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientConsumer {

    @Autowired
    private ClientService clientService;

    @RabbitListener(queues = {"${queue.client.name}"})
    public void receive (@Payload Client client){
        System.out.println("Id: "+ client.getId() + "\nNome: " + client.getNome());
        //Inserir dado no Mongo
        clientService.save(client);
    }
}