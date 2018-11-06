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
	/** Instance unique non préinitialisée */
	private static ScannerProvider INSTANCE = null;

	/** Constructeur privé */
	private ScannerProvider() {
		this.scanner = new Scanner(System.in);
	}

	public Scanner getScanner() {
		return scanner;
	}

	/** Point d'accès pour l'instance unique du singleton */
	public static synchronized ScannerProvider getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ScannerProvider();
		}
		return INSTANCE;
	}

	/**
	 * Teste si la saisie user est un int
	 * @return
	 */
	public boolean hasNextInt() {
		boolean flag = false;

		if (this.scanner.hasNextInt()) {
			flag = true;
		} else {
			this.scanner.nextLine();
		}
		return flag;
	}

	/**
	 * Renvoie le prochain int
	 * @return
	 */
	public int NextInt() {
		int result = this.scanner.nextInt();

		if (this.scanner.hasNextLine()) {
			this.scanner.nextLine();
		}
		return result;
	}

	/**
	 * Renvoie la prochaine String
	 * @return
	 */
	public String nextString() {
		String str = new String();

		str = this.scanner.nextLine();
		if (this.scanner.hasNextLine()) {
			this.scanner.nextLine();
		}
		return str;
	}

	public String nextLine() {
		return this.scanner.nextLine();
	}

	public void close_scanner() {
		this.scanner.close();
	}
}
