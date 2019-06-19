package br.com.valhalla.barber.controller;


import br.com.valhalla.barber.domain.Cliente;
import br.com.valhalla.barber.domain.Profissional;
import br.com.valhalla.barber.domain.Reserva;
import br.com.valhalla.barber.domain.Servico;
import br.com.valhalla.barber.services.ClienteService;
import br.com.valhalla.barber.services.ProfissionalService;
import br.com.valhalla.barber.services.ReservaService;
import br.com.valhalla.barber.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoService servicoService;

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

//    @RequestMapping (value = "/nome/{nome}", method = RequestMethod.GET)
//    public ResponseEntity<Reserva> buscarPorProfissional(@PathVariable("nome") String nome){
//        Optional<Profissional> profissional = profissionalService.findByUsuario(nome);
//        if (!profissional.isPresent())
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        Optional<Reserva> reserva = service.findByProfissional(profissional.get());
//        if (!reserva.isPresent())
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//
//        return new ResponseEntity(service.save(reserva.get()), HttpStatus.OK);
//    }

    @RequestMapping (value = "/profissional/usuario/{usuario}", method = RequestMethod.GET)
    public ResponseEntity<List<Reserva>> buscarPorUsuarioProfissional(@PathVariable("usuario") String usuario){
        Optional<Profissional> profissional = profissionalService.findByUsuario(usuario);
        if (!profissional.isPresent())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        List<Reserva> reserva = service.findByProfissional(profissional.get());

        return new ResponseEntity(reserva, HttpStatus.OK);
    }

    @RequestMapping (value = "/cliente/usuario/{usuario}", method = RequestMethod.GET)
    public ResponseEntity<List<Reserva>> buscarPorUsuarioCliente(@PathVariable("usuario") String usuario){
        Optional<Cliente> cliente = clienteService.findByUsuario(usuario);
        if (!cliente.isPresent())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        List<Reserva> reserva = service.findByCliente(cliente.get());

        return new ResponseEntity(reserva, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Reserva reserva) {
        //Verifica se será possível realizar a reserva, se ja existir reserva naquele horario lança um http status
        Optional<Reserva> fetchedReserva =
                service.verificaReserva(reserva.getProfissional(), reserva.getData(), reserva.getHora());
        if (fetchedReserva.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        Optional<Profissional> profissional = profissionalService.findById(reserva.getProfissional().getIdProfissional());
        if (!profissional.isPresent()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Optional<Cliente> cliente = clienteService.findByUsuario(reserva.getCliente().getUsuario());
        if(!cliente.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        reserva.setProfissional(profissional.get());
        reserva.setCliente(cliente.get());

        //Busca a estrutura dos servicos no banco
        List<Servico> fetchedServicos = new ArrayList<>();
        for ( Servico serv : reserva.getServicos() ) { ;
            fetchedServicos.add(servicoService.findById(serv.getIdServico()).get());
        }
        reserva.setServicos(fetchedServicos);

        //Realiza o calculo do valor total
        Double total = 0.0;
        for(Servico serv : reserva.getServicos()){
            total += serv.getValor();
        }
        reserva.setValorTotal(total);

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

    @PutMapping("/delete/{reservaId}")
    public ResponseEntity delete (@PathVariable Integer reservaId ){
         Optional<Reserva> reserva = service.deleteById(reservaId);
         return new ResponseEntity(HttpStatus.OK);
    }
}
