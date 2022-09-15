package com.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiModel;
import com.example.model.ArchModel;
import com.example.repository.ApiRepo;

@EnableAutoConfiguration
@RestController()
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	ApiRepo apirepo;

	@PostMapping("/archiviazione")
	public ResponseEntity <?> arch(@RequestBody ApiModel a) throws Exception {
		
		
		String dataUno = a.getDataUno(); //GETTING FIRST DATE
		String dataDue = a.getDataDue(); //GETTING 2ND DATE
		String codice = a.getCodice();	 //GETTING CODE
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");	//SETTING FORMAT DATE
		
		//CHECK CODE != 4
		if (codice.length() != 4) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore, il codice deve essere di 4 cifre");
			
		}
		
		
		//CHECK DATE FORMAT CORRECT
		try {
			
			LocalDate dataunoformat = LocalDate.parse(dataUno, formatter);
			LocalDate datadueformat = LocalDate.parse(dataDue, formatter);
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore, la data deve essere in questo formato dd-MM-yyyy");
		}
		
		
		//SUBSTRING ONLY YEAR (1ST DATE, 2ND DATE)
		
		dataUno = dataUno.substring(6);
		dataDue = dataDue.substring(6);
		
		
		int codicetrenta = Integer.parseInt(codice);	//TRASFORM STRING CODE TO INT
		int codicetren = (codicetrenta * 30) / 100;		//30% CODE
		
		
		
		//CHECK 1ST DATE EQUALS 2ND DATADUE
		if(Integer.parseInt(dataUno) == Integer.parseInt(dataDue)) {
			
			
			System.out.println(a.getCodice() + "" + dataUno + "" + codicetrenta);
			ArchModel archiviazione = new ArchModel(codice + "_" + dataDue + "_" + codicetren, false);	//ARCHIVE CODE + 1ST DATE, 2ND DATE, CODE
			apirepo.save(archiviazione);	//SAVE IN DATABASE
			
			
		} else if (Integer.parseInt(dataUno) > Integer.parseInt(dataDue)) {

			
			System.out.println(a.getCodice() + "" + dataDue + "" + dataUno + "" + codicetrenta);
			
			ArchModel archiviazione = new ArchModel(codice + "_" + dataDue + "_" + dataUno + "_" + codicetren, false);
			apirepo.save(archiviazione);
			
		} else {
			
			System.out.println(a.getCodice() + "" + dataUno + "" + dataDue + "" + codicetrenta);
			
			ArchModel archiviazione = new ArchModel(codice + "_" + dataUno + "_" + dataDue + "_" + codicetren, false);
			apirepo.save(archiviazione);
		}
		
		return null;
	}
}
	