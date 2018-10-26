/**
 * 
 */
package com.imie.gamerpg;

import java.util.ArrayList;

import com.imie.gamerpg.database.contract.ArmeContract;
import com.imie.gamerpg.database.contract.Contract;
import com.imie.gamerpg.database.dao.DAOManager;
import com.imie.gamerpg.database.dto.ArmeDTO;
import com.imie.gamerpg.database.dto.DTO;
import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.arme.ArmeMagique;
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
		
		Manager manager = new Manager();
		manager.insertArmes();
	}
}

