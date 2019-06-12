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
public class Login implements Serializable {

    private static final long serialVersionUID = 464575183124759944L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idLogin = null;

    private String usuario = null;
    private String senha = null;
    private String tipo = null;

}
