package br.com.valhalla.barber.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Administrador implements Serializable {

    private static final long serialVersionUID = 464575148289944L;

    @Id
    @GeneratedValue
    private Integer idAdministrador = null;

    /** Checks if the Transaction is activated. */
    private boolean activated = false;

    private String nome = null;

    private String cpf = null;
    
    private String email = null;

    private String usuario = null;

    private Integer senha = null;


}