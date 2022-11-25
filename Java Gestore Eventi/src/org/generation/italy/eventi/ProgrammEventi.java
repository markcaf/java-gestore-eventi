package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		setTitolo(titolo);
		this.eventi = new ArrayList<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}
	
	public void addEvento(Evento e) {
		eventi.add(e);
	}
	
	public List<Evento> getEventiByData(LocalDate data) {
		List<Evento> eventiByData = new ArrayList<>();
		for (Evento e : eventi) {
			if (e.getData().equals(data)) {
				eventiByData.add(e);
			}
		}
		return eventiByData;
	}
	
	public int getCountEventi() {
		return eventi.size();
	}
	
	public void clearEventi() {
		eventi.clear();
	}
	
	public String getDataTitoloFormat() {
		String dataTitoloFormat = getTitolo() + "\n";
		sortEventi();
		for (Evento e : eventi) {
			dataTitoloFormat += e.getDataFormattata() + " - " + e.getTitolo() + "\n";
		}
		return dataTitoloFormat;
	}
	
	private void sortEventi() {
		eventi.sort((e1, e2) -> e1.getData().compareTo(e2.getData()));
	}
	
	@Override
	public String toString() {
		return getDataTitoloFormat();
	}
	
}
