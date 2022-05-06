package br.com.projAulaSpring.controller;
import br.com.projAulaSpring.constant.Constants;
import br.com.projAulaSpring.model.Client;
import br.com.projAulaSpring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(Constants.API_CLIENT)
    public void save(@RequestBody Client client){
        clientService.sendClientRabbit(client);
    }

    @GetMapping(Constants.API_CLIENT)
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @PutMapping(Constants.API_CLIENT)
    public void update(@RequestBody Client client){
        clientService.save(client);
    }

    @DeleteMapping(Constants.API_CLIENT + "/{id}")
    public void delete(@PathVariable("id") String id){
        clientService.delete(id);
    }

    @GetMapping(Constants.API_CLIENT + "/{id}")
    public Optional<Client> findById(@PathVariable("id") String id){
        return clientService.findById(id);
    }
}