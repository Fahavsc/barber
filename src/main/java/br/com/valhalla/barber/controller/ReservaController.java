package br.com.valhalla.barber.controller;


import br.com.valhalla.barber.domain.Profissional;
import br.com.valhalla.barber.domain.Reserva;
import br.com.valhalla.barber.services.ProfissionalService;
import br.com.valhalla.barber.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(value = "*")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping
    public List<Reserva> getAll() {
        return service.findAll();
    }

    @GetMapping("/{reservaId}")
    public ResponseEntity get(@PathVariable Integer reservaId) {

        Optional<Reserva> fetchedReserva = this.service.findById(reservaId);

        if (fetchedReserva.isPresent()) {
            return new ResponseEntity(fetchedReserva, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Reserva reserva) {
        Optional<Reserva> fetchedReserva =
                service.verificaReserva(reserva.getProfissional(), reserva.getData(), reserva.getHora());
        if (fetchedReserva.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        Optional<Profissional> profissional = profissionalService.findById(reserva.getProfissional().getIdProfissional());
        if (!profissional.isPresent()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        reserva.setProfissional(profissional.get());
        return new ResponseEntity(service.save(reserva), HttpStatus.CREATED);

    }
    @PutMapping("/{reservaId}")
    public ResponseEntity put(@RequestBody Reserva reserva, @PathVariable Integer reservaId) {
        Optional<Reserva> fetchedReserva = this.service.findById(reservaId);
        if (fetchedReserva.isPresent()) {
            Reserva reservaUpdate = fetchedReserva.get();
            reservaUpdate.setHora(reserva.getHora());
            reservaUpdate.setValorTotal(reserva.getValorTotal());

            return new ResponseEntity(service.save(reservaUpdate), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
