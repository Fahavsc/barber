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

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 464575183124759944L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCliente = null;
    
    private String nome = null;
    private String cpf = null;
    private Integer telefone = null;
    private String email = null;
    private String usuario = null;
<<<<<<< HEAD
    private Integer senha = null;

    @JsonIgnore
=======
    private String senha = null;
    
>>>>>>> ff870353fedca7308e6b34c2bd1a92eceb821ee5
    @OneToMany(mappedBy="cliente")
    private List<Reserva> reservas = new ArrayList<>();
}
