package br.com.valhalla.barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.barber.domain.Reserva;
import br.com.valhalla.barber.repositories.ReservaRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    //Pesquisar todos
    public List<Reserva> findAll() {
        return this.repository.findAll();
    }

    //Pesquisar por id
    public Optional<Reserva> findById(Integer id) {
        return this.repository.findById(id);
    }

    //Salvar
    public Reserva save(Reserva reserva) {
        return this.repository.save(reserva);
    }

    //Deletar
    public Optional<Reserva> deleteById(Integer id) {

        Optional<Reserva> fetchedReserva = this.repository.findById(id);
        
        if (fetchedReserva.isPresent()) {
            this.repository.deleteById(id);
            
        }
        return fetchedReserva;
    }
}
