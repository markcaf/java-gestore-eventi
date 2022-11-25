package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//MILESTONE 1 & 2
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("Inserisci il titolo dell'evento: ");
//		String titolo = sc.nextLine();
//		
//		System.out.print("\nInserisci la data dell'evento (Anno-Mese-Giorno): ");
//		String dataStr = sc.next();
//		LocalDate data = LocalDate.parse(dataStr);
//		
//		System.out.print("\nInserisci il numero di posti totali dell'evento: ");
//		int postiTotali = sc.nextInt();
//		
//		System.out.println("\n-------------------------------\n");
//		
//		Evento eventoUtente = null;
//		try {
//			eventoUtente = new Evento(titolo, data, postiTotali);
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		} finally {
//			System.out.println(eventoUtente == null ? "L'evento non può essere creato" : eventoUtente);
//		}
//		
//		if (eventoUtente != null) {
//			boolean exit = false;
//			
//			while(!exit) {
//				
//				System.out.println("\n-------------------------------\n");
//			
//				System.out.println("Scegli un opzione per l'operazione da svolgere"
//						+ "\n1. Prenota evento"
//						+ "\n2. Disdici evento"
//						+ "\n3. Termina operazioni");
//				int sceltaUtente = sc.nextInt();
//				
//				
//				if (sceltaUtente == 1) {
//					System.out.print("Inserisci il numero di prenotazioni da effettuare: ");
//					int daPrenotare = sc.nextInt();
//					for (int i=0; i < daPrenotare; i++) {
//						try {
//							eventoUtente.prenota();
//						} catch (Exception e) {
//							System.err.println(e.getMessage());
//						}
//						
//						eventoUtente.prenota();
//					}
//					int postiDisponibili = eventoUtente.getPostiTotali() - eventoUtente.getPostiPrenotati();
//					System.out.println("\nTotale posti prenotati: " + eventoUtente.getPostiTotali());
//					System.out.println("Totale posti disponibili: " + postiDisponibili);
//				}
//				
//				if (sceltaUtente == 2) {
//					System.out.print("Inserisci il numero di prenotazioni da disdire: ");
//					int daDisdire = sc.nextInt();
//					for (int i=0; i < daDisdire; i++) {
//						try {
//							eventoUtente.disdici();
//						} catch (Exception e) {
//							System.err.println(e.getMessage());
//						}
//					}
//					int postiDisponibili = eventoUtente.getPostiTotali() - eventoUtente.getPostiPrenotati();
//					System.out.println("\nTotale posti prenotati: " + eventoUtente.getPostiPrenotati());
//					System.out.println("Totale posti disponibili: " + postiDisponibili);
//				}
//				
//				if (sceltaUtente == 3 || sceltaUtente != 1 && sceltaUtente != 2) {
//					System.out.print("\nTermine operazioni.");
//					exit = true;
//				}
//				
//			}
//			
//		}
//		
//		sc.close();
		
		
		//MILESTONE 3
		Evento e1 = null;
		Evento e2 = null;
		Evento e3 = null;
		Evento e4 = null;
		Evento e5 = null;
		Evento e6 = null;
		
		try {
			e1 = new Evento("Inter-Napoli", LocalDate.parse("2023-01-04"), 3000 );
			e2 = new Evento("Napoli-Juventus", LocalDate.parse("2023-01-12"), 2000 );
			e3 = new Evento("Salernitana-Napoli", LocalDate.parse("2023-01-21"), 1000 );
			e4 = new Evento("Napoli-Roma", LocalDate.parse("2023-01-29"), 2000 );
			e5 = new Evento("Napoli(U21)-Lazio(U21)", LocalDate.parse("2023-01-29"), 100);
			e6 = new Evento("Spezia-Napoli", LocalDate.parse("2023-02-05"), 1000 );
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		ProgrammEventi programm = new ProgrammEventi("Calendario partite del Napoli");
		programm.addEvento(e1);
		programm.addEvento(e2);
		programm.addEvento(e3);
		programm.addEvento(e4);
		programm.addEvento(e5);
		programm.addEvento(e6);
		System.out.println(programm);
		
		List<Evento> eventi29Gennaio = programm.getEventiByData(LocalDate.parse("2023-01-29"));
		
		System.out.println("Eventi presenti il 29 Gennaio 2023: \n" + eventi29Gennaio);
		System.out.println("\nNumero eventi presenti nel programma: " + programm.getCountEventi());
		programm.clearEventi();
		System.out.println("\n-------------------------------\n");
		System.out.println("Numero eventi presenti nel programma dopo clear: " + programm.getCountEventi());
	}

}
