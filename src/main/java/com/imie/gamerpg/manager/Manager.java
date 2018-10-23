/**
 * 
 */
package com.imie.gamerpg.manager;

import java.util.ArrayList;

import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.arme.ArmePhysique;
import com.imie.gamerpg.entity.armure.ArmurePhysique;
import com.imie.gamerpg.entity.interfaceclass.Barbare;
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
	
	public void addHero() {
		Hero hero = new Hero("myOrc", 100, 10, new ArmePhysique("epée", 20, 0, 5), new ArmurePhysique("armureMaille", 0, 10), Barbare);
		
		heros.add(hero);
	}
	
	public void init() {
		
	}
	
	public void game() {
		
	}

}
