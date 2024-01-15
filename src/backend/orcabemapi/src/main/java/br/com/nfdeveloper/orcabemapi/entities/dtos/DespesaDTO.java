package br.com.nfdeveloper.orcabemapi.entities.dtos;

import java.io.Serializable;
import java.util.Date;

public class DespesaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String descricao;
	private Double valor;
	private Date data_cadastro;
	private Date data_pagamento;
	private Date vencimento;
	private Boolean pago;
	private Long categoria_id;
	
	public DespesaDTO() {
	
	}

	public DespesaDTO(String descricao, Double valor, Date data_cadastro, Date data_pagamento, Date vencimento,
			Boolean pago, Long categoria_id) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.data_cadastro = data_cadastro;
		this.data_pagamento = data_pagamento;
		this.vencimento = vencimento;
		this.pago = pago;
		this.categoria_id = categoria_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Long getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}
	
	
}
