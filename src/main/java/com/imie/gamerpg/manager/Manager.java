/**
 * 
 */
package com.imie.gamerpg.manager;

import java.util.ArrayList;

import com.imie.gamerpg.database.contract.ArmeContract;
import com.imie.gamerpg.database.contract.Contract;
import com.imie.gamerpg.database.dao.DAOManager;
import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.arme.ArmeMagique;
import com.imie.gamerpg.entity.arme.ArmeMixte;
import com.imie.gamerpg.entity.arme.ArmePhysique;
import com.imie.gamerpg.entity.armure.ArmureMagique;
import com.imie.gamerpg.entity.armure.ArmureMixte;
import com.imie.gamerpg.entity.armure.ArmurePhysique;
import com.imie.gamerpg.entity.defaultcharacters.DefaultFighter;
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
		addHero();
		addMonstre();
	}

	public void addHero() {
		Hero hero = new Hero("leBarbare", 100, 10, new ArmePhysique("epée", 20, 0, 5),
				new ArmurePhysique("armureMaille", 0, 10), new DefaultFighter());
		Hero hero2 = new Hero("leMagicien", 100, 10, new ArmeMagique("baguette", 0, 15, 8),
				new ArmureMagique("armureTissu", 10, 0), new DefaultFighter());
		Hero hero3 = new Hero("lePaladin", 100, 10, new ArmeMixte("epée de flamme", 10, 10, 5),
				new ArmureMixte("armureGlaciale", 5, 5), new DefaultFighter());
		Hero hero4 = new Hero("leFighter", 100, 10, new ArmeMixte("lame d'acier", 10, 10, 5),
				new ArmureMixte("armureBlack", 5, 5), new DefaultFighter());

		heros.add(hero);
		heros.add(hero2);
		heros.add(hero3);
		heros.add(hero4);
	}

	public void addMonstre() {
		Monstre monstre = new Monstre("leMonstreBarbare", 100, 10, new ArmePhysique("epée", 20, 0, 5),
				new ArmurePhysique("armureMaille", 0, 10), new DefaultFighter());
		Monstre monstre2 = new Monstre("leMonstreMagicien", 100, 10, new ArmeMagique("baguette", 0, 15, 8),
				new ArmureMagique("armureTissu", 10, 0), new DefaultFighter());
		Monstre monstre3 = new Monstre("leMonstrePaladin", 100, 10, new ArmeMixte("epée de flamme", 10, 10, 5),
				new ArmureMixte("armureGlaciale", 5, 5), new DefaultFighter());
		Monstre monstre4 = new Monstre("leMonstreFighter", 100, 10, new ArmeMixte("lame d'acier", 10, 10, 5),
				new ArmureMixte("armureBlack", 5, 5), new DefaultFighter());

		monstres.add(monstre);
		monstres.add(monstre2);
		monstres.add(monstre3);
		monstres.add(monstre4);
	}

	public void init() {

	}

	public void game() {

	}
}
