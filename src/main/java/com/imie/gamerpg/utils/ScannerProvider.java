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

	/** Constructeur privé */
	private ScannerProvider() {
		this.scanner = new Scanner(System.in);
	}

	/** Instance unique non préinitialisée */
	private static ScannerProvider INSTANCE = null;

	/** Point d'accès pour l'instance unique du singleton */
	public static synchronized ScannerProvider getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ScannerProvider();
		}
		return INSTANCE;
	}

	public int NextInt() {
		int result = this.scanner.nextInt();

		if (this.scanner.hasNextLine() && this.scanner.hasNextInt()) {
			this.scanner.nextLine();
		}
		return result;
	}
}
