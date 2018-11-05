package com.imie.gamerpg.entity.interfaceclass;

import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.armure.Armure;
import com.imie.gamerpg.entity.personnage.Personnage;

public interface ClasseRPG {
	public void setMe(Personnage me);
	public String getArmorRestriction();
	public String getWeaponRestriction();
	public void fight(Personnage defender);
	public boolean isEquipable(Arme arme);
	public boolean isEquipable(Armure armure);
}
