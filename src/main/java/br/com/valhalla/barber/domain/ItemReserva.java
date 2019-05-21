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
public class ItemReserva {

    @Id
    @GeneratedValue
    private Integer id = null;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Servico servico = null;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "itemReserva")
    private Reserva reserva = null;
}
