package br.com.valhalla.barber.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer idReserva = null;

	@ManyToOne
    @JoinColumn(name = "fk_id_profissional")
    private Profissional profissional = null;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_cliente")
    private Cliente cliente = null;

    @Temporal(TemporalType.DATE)
    private Date data = null;

    //@JsonBackReference
    @ManyToMany
    @JoinTable(name="RESERVA_SERVICO",
    		   joinColumns = @JoinColumn(name="fk_reserva"), //Nome da FK da tabela dessa entidade que ser colocada na tabela auxiliar
    		   inverseJoinColumns = @JoinColumn(name="fk_servicos") //Nome da Fk da outra entidade que sera colocada na tabela auxiliar
    		  )
    List<Servico> servicos = new ArrayList<>();

    private Integer hora = null;

    private Double valorTotal = null;
}
