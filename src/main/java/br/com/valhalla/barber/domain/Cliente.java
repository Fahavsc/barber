package br.com.valhalla.barber.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 464575183124759944L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer idCliente = null;
    
    private String nome = null;
    private String cpf = null;
    private String telefone = null;
    private String email = null;
    private String usuario = null;
    private String senha = null;

    @JsonIgnore
    @OneToMany(mappedBy="cliente")
    private List<Reserva> reservas = new ArrayList<>();
}
