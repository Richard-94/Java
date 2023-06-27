package com.eoicode.classes;

import java.util.Date;

public class Eccomerce_Cliente {
	public String codice_cliente;
	public String nome_cognome;
	public String email;
	public Date data_iscrizione;
	
	public Eccomerce_Cliente(String codice_cliente,String nome_cognome,String email, Date data_iscrizione) {
		this.codice_cliente = codice_cliente;
		this.nome_cognome = nome_cognome;
		this.email = email;
		this.data_iscrizione = data_iscrizione;
	}
	

}
