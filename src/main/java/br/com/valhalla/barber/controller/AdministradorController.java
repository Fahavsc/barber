package br.com.valhalla.barber.controller;

import br.com.valhalla.barber.domain.Administrador;
import br.com.valhalla.barber.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService service;

    @GetMapping
    public List<Administrador> getAll() {
        return service.findAll();
    }

    @GetMapping("/{administradorId}")
    public ResponseEntity get(@PathVariable Integer administradorId) {

        Optional<Administrador> fetchedAdministrador = this.service.findById(administradorId);

        if(fetchedAdministrador.isPresent()) {
            return new ResponseEntity(fetchedAdministrador, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Administrador post(@RequestBody Administrador administrador) {
        return this.service.save(administrador);
    }

    @PutMapping("/{administradorId}")
    public ResponseEntity put(@RequestBody Administrador administrador, @PathVariable Integer administradorId) {
        Optional<Administrador> fetchedAdministrador = this.service.findById(administradorId);
        if(fetchedAdministrador.isPresent()) {
            Administrador administradorUpdate = fetchedAdministrador.get();
            administradorUpdate.setNome(administrador.getNome());
            administradorUpdate.setCpf(administrador.getCpf());
            administradorUpdate.setEmail(administrador.getEmail());
            administradorUpdate.setUsuario(administrador.getUsuario());
            administradorUpdate.setSenha(administrador.getSenha());
            return new ResponseEntity(service.save(administradorUpdate),HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{administradorId}")
    public Optional<Administrador> delete(@PathVariable Integer administradorId) {
        return service.deleteById(administradorId);
    }
}