/**
 * 
 */
package com.imie.gamerpg.manager;

import java.util.ArrayList;

import com.imie.gamerpg.entity.personnage.Hero;
import com.imie.gamerpg.entity.personnage.Monstre;

/**
 * @author Fabrice
 *
 */
public class Manager {
	
	ArrayList<Hero> heros;
	ArrayList<Monstre> monstres;
	
	/**
	 * Constructeur manager
	 */
	public Manager() {
		super();
		this.heros = new ArrayList<Hero>();
		this.monstres = new ArrayList<Monstre>();
	}
	
	public void init() {
		
	}
	
	public void game() {
		
	}

}
