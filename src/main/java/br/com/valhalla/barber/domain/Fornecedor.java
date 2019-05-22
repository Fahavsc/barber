package br.com.valhalla.barber.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Fornecedor implements Serializable {

	@Id
    @GeneratedValue
    private Integer idFornecedor = null;
    
	/** Checks if the Transaction is activated. */
    private boolean activated = false;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduto")
    private Produto produto = null;
	
    private String nome = null;

    private Integer cnpj = null;


}