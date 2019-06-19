package br.com.valhalla.barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.barber.domain.Cliente;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

    Optional<Cliente> findByUsuarioContaining(String usuario);

}
