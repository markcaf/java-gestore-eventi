package org.generation.italy.eventi;

import java.time.LocalDate;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception {
		setTitolo(titolo);
		setData(data);
		if(postiTotali < 0) {
			throw new Exception("Il numero di posti totali non può essere inferiore a 0");
		}
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("La data inserita non è valida");
		}
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public void prenota() throws Exception {
		if (data.isBefore(LocalDate.now()) || postiPrenotati == postiTotali) {
			throw new Exception("L'evento è già passato o non ha posti disponibili");
		}
		postiPrenotati++;
	}
	
	

}
