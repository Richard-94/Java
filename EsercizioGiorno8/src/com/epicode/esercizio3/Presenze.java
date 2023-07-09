package com.epicode.esercizio3;

public class Presenze {
	
	private String nome;
	private int numPresenze;
	
	public Presenze(String nome, int numPresenze) {
		super();
		this.nome = nome;
		this.numPresenze = numPresenze;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumPresenze() {
		return numPresenze;
	}

	public void setNumPresenze(int numPresenze) {
		this.numPresenze = numPresenze;
	}

	@Override
	public String toString() {
		return "Presenze [nome=" + nome + ", numPresenze=" + numPresenze + "]";
	}
	
	

}
