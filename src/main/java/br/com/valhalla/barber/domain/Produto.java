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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Produto implements Serializable {

	@Id
    @GeneratedValue
    private Integer idServico = null;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFornecedor")
	private Fornecedor fornecedor = null;
	
    private String nome = null;

    private Double valor = null;

    private String tipo = null;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idItemProduto")
    private ItemProduto itemProduto = null;

}
