package br.com.valhalla.barber.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Profissional implements Serializable {

    private static final long serialVersionUID = 4645751831248289944L;

    @Id
    @GeneratedValue
    private Integer idProfissional = null;

    private String nome = null;

    private String cpf = null;
    
    private String email = null;
    
    private String especializacao = null;

    private String usuario = null;

    private String senha = null;

    @JsonIgnore
    @OneToMany(mappedBy = "profissional")
    private List<Reserva> reservas = new ArrayList<>();
    //Luis - Vou pegar um projeto do trampo que tem o Calendar e vou utilizar para fazer o Day off

}
