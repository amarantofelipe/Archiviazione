package com.example.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class ApiModel {

	@Column(name = "id")
	private @Id @GeneratedValue int id;
	
	@Column(name = "dataUno")
	private String dataUno;
	
	public String getDataUno() {
		return dataUno;
	}

	public void setDataUno(String dataUno) {
		this.dataUno = dataUno;
	}

	public String getDataDue() {
		return dataDue;
	}

	public void setDataDue(String dataDue) {
		this.dataDue = dataDue;
	}

	@Column(name = "dataDue")
	private String dataDue;
	
	@Column(name = "codice")
	private String codice;
	
	@Column(name = "elaborazione")
	private boolean elaborazione;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public boolean isElaborazione() {
		return elaborazione;
	}

	public void setElaborazione(boolean elaborazione) {
		this.elaborazione = elaborazione;
	}

	

	public ApiModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Override
	public String toString() {
		return "ApiModel [id=" + id + ", dataUno=" + dataUno + ", dataDue=" + dataDue + ", codice=" + codice
				+ ", elaborazione=" + elaborazione + "]";
	}


	
}
