package br.com.valhalla.barber.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Servico {

    @Id
    @GeneratedValue
    private Integer id = null;

    private String nome = null;

    private Double valor = null;

    private Integer tempo = null;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva")
    private ItemReserva itemReserva = null;

}
