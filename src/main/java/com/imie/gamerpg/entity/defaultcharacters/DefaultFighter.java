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
import com.imie.gamerpg.entity.interfaceclass.ClasseRPG;
import com.imie.gamerpg.entity.interfaceclass.Magicien;
import com.imie.gamerpg.entity.interfaceclass.Paladin;
import com.imie.gamerpg.entity.personnage.Personnage;

/**
 * @author Romain
 *
 */
public class DefaultFighter implements ClasseRPG {
	/**
	 *
	 */
	protected Personnage me;

	public DefaultFighter() {}

	public void setMe(Personnage me) {
		this.me = me;
	}

	/**
	 * Fonction qui renvoie la restriction d'armure
	 */
	public String getArmorRestriction() {
		String toReturn = new String();

		toReturn = "Le personnage ne peut équiper qu'une armure ";
		if (this instanceof Paladin) {
			toReturn += "Mixte||Magique";
		} else if (this instanceof Magicien) {
			toReturn += "Magique";
		} else if (this instanceof Barbare) {
			toReturn += "Physique";
		} else if (this instanceof DefaultFighter) {
			toReturn += "Physique||Magique||Mixte";
		}
		toReturn += ".";
		return toReturn;
	}

	/**
	 * Fonction qui renvoie la restriction d'arme
	 */
	public String getWeaponRestriction() {
		String toReturn = new String();

		toReturn = "Le personnage ne peut équiper qu'une arme ";
		if (this instanceof Paladin) {
			toReturn += "Mixte||Magique";
		} else if (this instanceof Magicien) {
			toReturn += "Magique";
		} else if (this instanceof Barbare) {
			toReturn += "Physique";
		} else if (this instanceof DefaultFighter) {
			toReturn += "Physique||Magique||Mixte";
		}
		toReturn += ".";
		return toReturn;
	}

	/**
	 * Fonction qui fait combattre le personnage courant contre le personnage défenseur
	 */
	public void fight(Personnage defender) {
		int degats = 0;
		int temp = 0;
		int tempPa = me.getPtsAction();

		while (tempPa >= me.getArme().getPtsAction()) {
			temp = me.getArme().getPtsAttaquePhysique() - defender.getArmure().getPtsArmurePhysique();
			if (temp > 0) {
				if (defender.getbonusArmurePhy() != 0) {
					if (temp > defender.getbonusArmurePhy()) {
						temp -= defender.getbonusArmurePhy();
						defender.setbonusArmurePhy(0);
					} else if (temp <= defender.getbonusArmurePhy()) {
						defender.setbonusArmurePhy(defender.getbonusArmurePhy() - temp);
						temp = 0;
					}
				}
				degats += temp;
			}
			temp = me.getArme().getPtsAttaqueMagique() - defender.getArmure().getPtsArmureMagique();
			if (temp > 0) {
				if (defender.getbonusArmureMag() != 0) {
					if (temp > defender.getbonusArmureMag()) {
						temp -= defender.getbonusArmureMag();
						defender.setbonusArmureMag(0);
					} else if (temp <= defender.getbonusArmureMag()) {
						defender.setbonusArmureMag(defender.getbonusArmureMag() - temp);
						temp = 0;
					}
				}
				degats += temp;
			}
			tempPa -= me.getArme().getPtsAction();
		}
		defender.setPtsVie(defender.getPtsVie() - degats);
	}

	/**
	 * Fonction qui fait se défendre le personnage
	 */
	public void defendre(Personnage me) {
		me.setbonusArmurePhy(me.getbonusArmurePhy() + me.getArmure().getPtsArmurePhysique());
		me.setbonusArmureMag(me.getbonusArmureMag() + me.getArmure().getPtsArmureMagique());
	}

	/**
	 * Fonction qui définit si l'arme est équipable ou non
	 */
	public boolean isEquipable(Arme arme) {
		boolean equipable = true;

		if (this instanceof Paladin && arme instanceof ArmePhysique) {
			equipable = false;
		}
		if (this instanceof Magicien && (arme instanceof ArmePhysique || arme instanceof ArmeMixte)) {
			equipable = false;
		}
		if (this instanceof Barbare && (arme instanceof ArmeMagique || arme instanceof ArmeMixte)) {
			equipable = false;
		}
		return equipable;
	}

	/**
	 * Fonction qui définit si l'armure est équipable ou non
	 */
	public boolean isEquipable(Armure armure) {
		boolean equipable = true;

		if (this instanceof Paladin && armure instanceof ArmurePhysique) {
			equipable = false;
		}
		if (this instanceof Magicien && (armure instanceof ArmurePhysique || armure instanceof ArmureMixte)) {
			equipable = false;
		}
		if (this instanceof Barbare && (armure instanceof ArmureMagique || armure instanceof ArmureMixte)) {
			equipable = false;
		}
		return equipable;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = new String();
		if (this instanceof DefaultFighter) {
			str = "Fighter";
		}
		if (this instanceof DefaultBarbare) {
			str = "Barbare";
		}
		if (this instanceof DefaultMagicien) {
			str = "Magicien";
		}
		if (this instanceof DefaultPaladin) {
			str = "Paladin";
		}
		return str;
	}
}
