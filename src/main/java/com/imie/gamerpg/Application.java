/**
 *
 */

package com.imie.gamerpg;

import com.imie.gamerpg.manager.Manager;

/**
 * @author Fabrice
 *
 */
public class Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager gameManager = new Manager();

		gameManager.menu();
	}
}

