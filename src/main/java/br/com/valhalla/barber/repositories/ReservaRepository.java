package br.com.valhalla.barber.repositories;

import br.com.valhalla.barber.domain.Cliente;
import br.com.valhalla.barber.domain.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.barber.domain.Reserva;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository <Reserva, Integer> {

    Optional<Reserva> findByProfissionalAndDataAndHora(Profissional profissional, Date date, Integer hora);

    Optional<Reserva> findByProfissional(Profissional profissional);

    List<Reserva> findByCliente(Cliente cliente);

}
