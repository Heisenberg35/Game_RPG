/**
 * 
 */
package com.imie.gamerpg.defaultcharacters;

import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.armure.Armure;
import com.imie.gamerpg.entity.personnage.Personnage;
import com.imie.gamerpg.interfaceclass.ClasseRPG;

/**
 * @author Romain
 *
 */
public class DefaultFighter implements ClasseRPG {

	public String getArmorRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWeaponRestriction() {
		// TODO Auto-generated method stub
		return null;
	}

	public void fight(Personnage defender) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEquipable(Arme arme) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEquipable(Armure armure) {
		// TODO Auto-generated method stub
		return false;
	}

}
