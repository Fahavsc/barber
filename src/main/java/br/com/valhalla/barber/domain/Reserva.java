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
    private Integer idReserva = null;

    /** Checks if the Transaction is activated. */
    private boolean activated = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfissional")
    private Profissional profissional = null;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Cliente cliente = null;

    @Temporal(TemporalType.DATE)
    private Date data = null;

    private Integer hora = null;

    private Double valorTotal = null;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idItemReserva")
    private ItemReserva itemReserva = null;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idItemProduto")
    private ItemReserva itemProduto = null;

}
