package br.com.valhalla.barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.barber.domain.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository <Profissional, Integer> {

}
