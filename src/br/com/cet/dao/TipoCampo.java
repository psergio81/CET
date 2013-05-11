package br.com.cet.dao;

public enum TipoCampo {

	INTEIRO(1),
	VARCHAR(2),
	DATA(3);

	
	private final int numero;

	public int getNumero() {
		return numero;
	}
	

	private TipoCampo(int numero) {
		this.numero = numero;
	}
	
}
