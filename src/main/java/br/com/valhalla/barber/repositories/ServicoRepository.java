package br.com.valhalla.barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.valhalla.barber.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository <Servico, Integer> {
    @Procedure(procedureName = "verServico")
    String nomeServico(@Param("id_reserva") int id);

}
