package br.com.valhalla.barber.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Reserva implements Serializable {

    @Id
    @GeneratedValue
    private Integer reservaId = null;

    /** Checks if the Transaction is activated. */
    private boolean activated = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Profissional profissional = null;

    @Temporal(TemporalType.DATE)
    private Date data = null;

    private Integer hora = null;

    private Double valorTotal = null;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva")
    private ItemReserva itemReserva = null;

}
