/**
 * 
 */
package com.imie.gamerpg;

import com.imie.gamerpg.database.dao.DAOManager;
import com.imie.gamerpg.entity.arme.Arme;
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
		DAOManager<Arme> daoManager = new DAOManager<Arme>();
		Manager game_manager = new Manager();

		game_manager.menu();

	}
}

