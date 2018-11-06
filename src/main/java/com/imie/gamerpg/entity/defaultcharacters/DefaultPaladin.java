/**
 * 
 */
package com.imie.gamerpg.entity.defaultcharacters;

import com.imie.gamerpg.entity.interfaceclass.Paladin;
import com.imie.gamerpg.entity.personnage.Personnage;

/**
 * @author Romain
 *
 */
public class DefaultPaladin extends DefaultFighter implements Paladin {

	public DefaultPaladin(Personnage character) {
		super(character);
		// TODO Auto-generated constructor stub
	}
	
	public void defendre(Personnage me) {
		me.setBonus_armure_phy(me.getBonus_armure_phy() + me.getArmure().getPtsArmurePhysique() + me.getArmure().getPtsArmurePhysique() /2);
		me.setBonus_armure_mag(me.getBonus_armure_mag() + me.getArmure().getPtsArmureMagique() + me.getArmure().getPtsArmureMagique() / 2);
	}

	public DefaultPaladin() {}
}
