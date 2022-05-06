package br.com.projAulaSpring.service;

import br.com.projAulaSpring.model.Client;
import br.com.projAulaSpring.rabbit.ClientProducer;
import br.com.projAulaSpring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientProducer clientProducer;

    public void sendClientRabbit(Client client){
        clientProducer.send(client);
    }
    public void save(Client client){
        clientRepository.save(client);
    }
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Optional<Client> findById(String id){
        return clientRepository.findById(id);
    }
    public void delete(String id){
        clientRepository.deleteById(id);
    }
    public void deleteAll(){
        clientRepository.deleteAll();
    }
}