package com.publio.cursomc.domain.enums;

public enum EstadoPagamento {
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	// Recebe um código e valida se existe o enum referente a ele
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		// Retorna o objeto referente ao código passado
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		// Caso não ache um objeto referente ao código passado, irá lançar uma excessão
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}