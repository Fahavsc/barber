package br.com.valhalla.barber.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 464575183124759944L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCliente = null;

    /** Checks if the Transaction is activated. */
    private boolean activated = false;
    
    private String nome = null;
    private String cpf = null;
    private Integer telefone = null;
    private String email = null;
    private String usuario = null;
    private Integer senha = null;
    
    @OneToMany(mappedBy="cliente")
    private List<Reserva> reservas = new ArrayList<>();

    

}
