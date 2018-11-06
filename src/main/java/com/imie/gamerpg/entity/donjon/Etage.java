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
	private int currEtage;
	private ArrayList<Monstre> monstre;

	public Etage(int nb) {
		this.currEtage = nb;
		monstre = new ArrayList<Monstre>();
	}

	public int getCurr_etage() {
		return currEtage;
	}

	public ArrayList<Monstre> getMonstre() {
		return monstre;
	}
}
