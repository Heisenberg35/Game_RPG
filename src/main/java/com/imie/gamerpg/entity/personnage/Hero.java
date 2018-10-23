/**
 * 
 */
package com.imie.gamerpg.entity.personnage;

import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.armure.Armure;

/**
 * @author Fabrice
 *
 */
public class Hero extends Personnage {

	public Hero(String nom, int ptsVie, int ptsAction, Arme arme, Armure armure) {
		super(nom, ptsVie, ptsAction, arme, armure);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getArmorRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWeaponRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fight(Personnage defender) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEquipable(Arme arme) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		// TODO Auto-generated method stub
		return false;
	}

}
