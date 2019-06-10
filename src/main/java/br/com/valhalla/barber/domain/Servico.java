package br.com.valhalla.barber.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idServico = null;

    private String nome = null;

    private Double valor = null;

    @JsonIgnore
    @ManyToMany(mappedBy="servicos")
    private List<Reserva> reservas = new ArrayList<>();
}
