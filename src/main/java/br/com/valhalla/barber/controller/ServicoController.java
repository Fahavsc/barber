package br.com.valhalla.barber.controller;

import br.com.valhalla.barber.domain.Servico;
import br.com.valhalla.barber.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servico")
@CrossOrigin(value = "*")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping
    public List<Servico> getAll() {
        return service.findAll();
    }

    @GetMapping("/{servicoId}")
    public ResponseEntity get(@PathVariable Integer servicoId) {

        Optional<Servico> fetchedServico = this.service.findById(servicoId);

        if(fetchedServico.isPresent()) {
            return new ResponseEntity(fetchedServico, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Servico post(@RequestBody Servico administrador) {
        return this.service.save(administrador);
    }

    @PutMapping("/{servicoId}")
    public ResponseEntity put(@RequestBody Servico servico, @PathVariable Integer servicoId) {
        Optional<Servico> fetchedServico = this.service.findById(servicoId);
        if(fetchedServico.isPresent()) {
            Servico servicoUpdate = fetchedServico.get();
            servicoUpdate.setNome(servico.getNome());
            servicoUpdate.setValor(servico.getValor());
            return new ResponseEntity(service.save(servicoUpdate),HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{servicoId}")
    public Optional<Servico> delete(@PathVariable Integer servicoId) {
        return service.deleteById(servicoId);
    }
}