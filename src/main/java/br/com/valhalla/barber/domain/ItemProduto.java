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
public class ItemProduto {

    @Id
    @GeneratedValue
    private Integer idItemProduto = null;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduto")
    private Produto produto = null;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "idReserva")
    private Reserva reserva = null;
}
