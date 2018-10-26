/**
 * 
 */
package com.imie.gamerpg.utils;

import java.util.Scanner;

/**
 * @author Fabrice
 *
 */
public class ScannerProvider {
	private Scanner scanner;

	public Scanner getScanner() {
		return scanner;
	}

	/** Constructeur priv� */
	private ScannerProvider() {
		this.scanner = new Scanner(System.in);
	}

	/** Instance unique non pr�initialis�e */
	private static ScannerProvider INSTANCE = null;

	/** Point d'acc�s pour l'instance unique du singleton */
	public static synchronized ScannerProvider getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ScannerProvider();
		}
		return INSTANCE;
	}

	public boolean hasNextInt() {
		boolean flag = false;
		
		if (this.scanner.hasNextInt())
			flag = true;
		else
			this.scanner.nextLine();
		return flag;
	}
	
	public int NextInt() {
		int result = this.scanner.nextInt();

		if (this.scanner.hasNextLine()) {
			this.scanner.nextLine();
		}
		return result;
	}

	public String nextString() {
		String str = new String();
		
		str = this.scanner.nextLine();
		if (this.scanner.hasNextLine()) {
			this.scanner.nextLine();
		}
		return str;
	}
	
	public void nextLine() {
		this.scanner.nextLine();
	}
	
	public void close_scanner() {
		this.scanner.close();
	}
}
