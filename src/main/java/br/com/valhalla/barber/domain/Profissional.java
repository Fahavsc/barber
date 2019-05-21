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
public class Profissional implements Serializable {

    private static final long serialVersionUID = 4645751831248289944L;

    @Id
    @GeneratedValue
    private Integer id = null;

    /** Checks if the Transaction is activated. */
    private boolean activated = false;

    private String nome = null;

    private String cpf = null;

    private String usuario = null;

    private Integer senha = null;

    //Luis - Vou pegar um projeto do trampo que tem o Calendar e vou utilizar para fazer o Day off

}
