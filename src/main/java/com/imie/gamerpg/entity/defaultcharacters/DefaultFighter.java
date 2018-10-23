/**
 * 
 */
package com.imie.gamerpg.entity.defaultcharacters;

import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.arme.ArmeMagique;
import com.imie.gamerpg.entity.arme.ArmeMixte;
import com.imie.gamerpg.entity.arme.ArmePhysique;
import com.imie.gamerpg.entity.armure.Armure;
import com.imie.gamerpg.entity.armure.ArmureMagique;
import com.imie.gamerpg.entity.armure.ArmureMixte;
import com.imie.gamerpg.entity.armure.ArmurePhysique;
import com.imie.gamerpg.entity.interfaceclass.Barbare;
import com.imie.gamerpg.entity.interfaceclass.Magicien;
import com.imie.gamerpg.entity.interfaceclass.Paladin;
import com.imie.gamerpg.entity.personnage.Personnage;

/**
 * @author Romain
 *
 */
public class DefaultFighter implements com.imie.gamerpg.entity.interfaceclass.ClasseRPG {

	public String getArmorRestriction() {
		String to_return = new String();
		
		if (this instanceof Paladin)
			to_return += "Mixte||Magique";
		else if (this instanceof Magicien)
			to_return += "Magique";
		else if (this instanceof Barbare)
			to_return += "Physique";
		return to_return;
	}

	public String getWeaponRestriction() {
		String to_return = new String();
		
		if (this instanceof Paladin)
			to_return += "Mixte||Magique";
		else if (this instanceof Magicien)
			to_return += "Magique";
		else if (this instanceof Barbare)
			to_return += "Physique";
		return to_return;
	}

	public void fight(Personnage defender) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEquipable(Arme arme) {
		boolean equipable = false;
		
		if (this instanceof Paladin && (arme instanceof ArmeMagique || arme instanceof ArmeMixte))
			equipable = true;
		else if (this instanceof Magicien && arme instanceof ArmeMagique)
			equipable = true;
		else if (this instanceof Barbare && arme instanceof ArmePhysique)
			equipable = true;
		return equipable;
	}

	public boolean isEquipable(Armure armure) {
		boolean equipable = false;
		
		if (this instanceof Paladin && (armure instanceof ArmureMagique || armure instanceof ArmureMixte))
			equipable = true;
		else if (this instanceof Magicien && armure instanceof ArmureMagique)
			equipable = true;
		else if (this instanceof Barbare && armure instanceof ArmurePhysique)
			equipable = true;
		return equipable;
	}

}
