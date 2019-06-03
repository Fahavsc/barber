package br.com.valhalla.barber.controller;

import br.com.valhalla.barber.domain.Profissional;
import br.com.valhalla.barber.services.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @GetMapping
    public List<Profissional> getAll() {
        return service.findAll();
    }

    @GetMapping("/{profissionalId}")
    public ResponseEntity get(@PathVariable Integer profissionalId) {

        Optional<Profissional> fetchedProfissional = this.service.findById(profissionalId);

        if(fetchedProfissional.isPresent()) {
            return new ResponseEntity(fetchedProfissional, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Profissional post(@RequestBody Profissional profissional) {
        return this.service.save(profissional);
    }

    @PutMapping("/{profissionalId}")
    public ResponseEntity put(@RequestBody Profissional administrador, @PathVariable Integer profissionalId) {
        Optional<Profissional> fetchedProfissional = this.service.findById(profissionalId);
        if(fetchedProfissional.isPresent()) {
            Profissional profissionalUpdate = fetchedProfissional.get();
            profissionalUpdate.setNome(administrador.getNome());
            profissionalUpdate.setCpf(administrador.getCpf());
            profissionalUpdate.setEmail(administrador.getEmail());
            profissionalUpdate.setUsuario(administrador.getUsuario());
            profissionalUpdate.setSenha(administrador.getSenha());
            return new ResponseEntity(service.save(profissionalUpdate),HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{profissionalId}")
    public Optional<Profissional> delete(@PathVariable Integer profissionalId) {
        return service.deleteById(profissionalId);
    }
}