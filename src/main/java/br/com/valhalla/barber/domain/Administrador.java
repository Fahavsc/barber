package br.com.valhalla.barber.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Administrador implements Serializable {

    private static final long serialVersionUID = 464575148289944L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer idAdministrador = null;

    private String nome = null;

    private String cpf = null;
    
    private String email = null;

    private String usuario = null;

    private String senha = null;


}