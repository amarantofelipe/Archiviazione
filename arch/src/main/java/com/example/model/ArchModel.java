package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class ArchModel {

	@Column(name = "id")
	private @Id @GeneratedValue int id;
	
	@Column(name = "timestamp")
	private @CreationTimestamp  LocalDate timestamp;
	
	@Column(name = "codice")
	private String codice;
	
	@Column(name = "elaborazione")
	private boolean elaborazione;

	public ArchModel (String codice, boolean elaborazione) {
		super();
		this.codice = codice;
		this.elaborazione = elaborazione;
	}
	
	
}
