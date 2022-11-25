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
		
		sc.close();
		System.out.println("\n-------------------------------\n");
		Evento eventoUtente = new Evento(titolo, data, postiTotali);
		System.out.println(eventoUtente);
		
	}

}
