/**
 * 
 */
package com.imie.gamerpg.entity.donjon;

import java.util.ArrayList;

import com.imie.gamerpg.entity.personnage.Monstre;

/**
 * @author Romain
 *
 */
public class Etage {
	private int curr_etage;
	private ArrayList<Monstre> monstre;

	public int getCurr_etage() {
		return curr_etage;
	}

	public ArrayList<Monstre> getMonstre() {
		return monstre;
	}

	public Etage(int nb) {
		this.curr_etage = nb;
		monstre = new ArrayList<Monstre>();
	}
}
