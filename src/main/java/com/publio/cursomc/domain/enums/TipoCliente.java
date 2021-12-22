package com.publio.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
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
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		// Retorna o objeto referente ao código passado
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		// Caso não ache um objeto referente ao código passado, irá lançar uma excessão
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
