/**
 * 
 */
package com.imie.gamerpg;

import com.imie.gamerpg.manager.Manager;
import com.imie.gamerpg.utils.ScannerProvider;

/**
 * @author Fabrice
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager game_manager = new Manager();
		
		//game_manager.insertArmes();
		game_manager.menu();
		ScannerProvider.getInstance().close_scanner();
	}
}

