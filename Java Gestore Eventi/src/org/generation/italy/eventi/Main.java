package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserisci il titolo dell'evento: ");
		String titolo = sc.nextLine();
		
		System.out.print("\nInserisci la data dell'evento (Anno-Mese-Giorno): ");
		String dataStr = sc.next();
		LocalDate data = LocalDate.parse(dataStr);
		
		System.out.print("\nInserisci il numero di posti totali dell'evento: ");
		int postiTotali = sc.nextInt();
		
		System.out.println("\n-------------------------------\n");
		
		//Evento eventoUtente = new Evento(titolo, data, postiTotali);
		//System.out.println(eventoUtente);
		
		Evento eventoUtente = null;
		try {
			eventoUtente = new Evento(titolo, data, postiTotali);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(eventoUtente == null ? "L'evento non può essere creato" : eventoUtente);
		}
		
		if (eventoUtente != null) {
			boolean exit = false;
			
			while(!exit) {
				
				System.out.println("\n-------------------------------\n");
			
				System.out.println("Scegli un opzione per l'operazione da svolgere"
						+ "\n1. Prenota evento"
						+ "\n2. Disdici evento"
						+ "\n3. Termina operazioni");
				int sceltaUtente = sc.nextInt();
				
				
				if (sceltaUtente == 1) {
					System.out.print("Inserisci il numero di prenotazioni da effettuare: ");
					int daPrenotare = sc.nextInt();
					for (int i=0; i < daPrenotare; i++) {
						try {
							eventoUtente.prenota();
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}
						
						eventoUtente.prenota();
					}
					int postiDisponibili = eventoUtente.getPostiTotali() - eventoUtente.getPostiPrenotati();
					System.out.println("\nTotale posti prenotati: " + eventoUtente.getPostiTotali());
					System.out.println("Totale posti disponibili: " + postiDisponibili);
				}
				
				if (sceltaUtente == 2) {
					System.out.print("Inserisci il numero di prenotazioni da disdire: ");
					int daDisdire = sc.nextInt();
					for (int i=0; i < daDisdire; i++) {
						try {
							eventoUtente.disdici();
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}
					}
					int postiDisponibili = eventoUtente.getPostiTotali() - eventoUtente.getPostiPrenotati();
					System.out.println("\nTotale posti prenotati: " + eventoUtente.getPostiPrenotati());
					System.out.println("Totale posti disponibili: " + postiDisponibili);
				}
				
				if (sceltaUtente == 3 || sceltaUtente != 1 && sceltaUtente != 2) {
					System.out.print("\nTermine operazioni.");
					exit = true;
				}
				
			}
		}
		
		
	}

}
