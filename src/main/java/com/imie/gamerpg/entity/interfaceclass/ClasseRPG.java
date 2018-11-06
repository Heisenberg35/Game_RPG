package com.imie.gamerpg.entity.interfaceclass;

import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.armure.Armure;
import com.imie.gamerpg.entity.personnage.Personnage;

/**
 *
 * @author Romain
 *
 */
public interface ClasseRPG {
	void setMe(Personnage me);

	void defendre(Personnage me);

	String getArmorRestriction();

	String getWeaponRestriction();

	void fight(Personnage defender);

	boolean isEquipable(Arme arme);

	boolean isEquipable(Armure armure);
}
