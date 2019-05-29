package br.com.valhalla.barber.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class ItemReserva {

    @Id
    @GeneratedValue
    private Integer idItemReserva = null;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "idServico")
    private Servico servico = null;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "idReserva")
    private Reserva reserva = null;
}
