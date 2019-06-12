package br.com.valhalla.barber.controller;

import br.com.valhalla.barber.domain.Cliente;
import br.com.valhalla.barber.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(value = "*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> getAll() {
        return service.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity get(@PathVariable Integer clienteId) {

        Optional<Cliente> fetchedCliente = this.service.findById(clienteId);

        if(fetchedCliente.isPresent()) {
            return new ResponseEntity(fetchedCliente, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Cliente post(@RequestBody Cliente cliente) {
        return this.service.save(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity put(@RequestBody Cliente cliente, @PathVariable Integer clienteId) {
        Optional<Cliente> fetchedCliente = this.service.findById(clienteId);
        if(fetchedCliente.isPresent()) {
            Cliente clienteUpdate = fetchedCliente.get();
            clienteUpdate.setNome(cliente.getNome());
            clienteUpdate.setCpf(cliente.getCpf());
            clienteUpdate.setEmail(cliente.getEmail());
            clienteUpdate.setUsuario(cliente.getUsuario());
            clienteUpdate.setSenha(cliente.getSenha());
            clienteUpdate.setTelefone(cliente.getTelefone());
            return new ResponseEntity(service.save(clienteUpdate),HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{clienteId}")
    public Optional<Cliente> delete(@PathVariable Integer clienteId) {
        return service.deleteById(clienteId);
    }
}