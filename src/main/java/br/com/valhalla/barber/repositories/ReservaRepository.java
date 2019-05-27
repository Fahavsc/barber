package br.com.valhalla.barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.barber.domain.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository <Reserva, Integer> {

}
