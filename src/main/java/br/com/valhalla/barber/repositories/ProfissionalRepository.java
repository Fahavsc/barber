package br.com.valhalla.barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.barber.domain.Profissional;

import java.util.Optional;

@Repository
public interface ProfissionalRepository extends JpaRepository <Profissional, Integer> {
    Optional<Profissional> findByNomeContaining(String nome);
}
