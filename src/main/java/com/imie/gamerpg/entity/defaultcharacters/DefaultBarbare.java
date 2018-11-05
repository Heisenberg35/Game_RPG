/**
 * 
 */
package com.imie.gamerpg.entity.defaultcharacters;

import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.interfaceclass.Barbare;
import com.imie.gamerpg.entity.personnage.Personnage;

/**
 * @author Romain
 *
 */
public class DefaultBarbare extends DefaultFighter implements Barbare {
	
	private Arme second_weapon;

	public Arme getSecond_weapon() {
		return second_weapon;
	}

	public void setSecond_weapon(Arme second_weapon) {
		this.second_weapon = second_weapon;
	}

	public DefaultBarbare(Personnage character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	public DefaultBarbare() {
		super();
		// TODO Auto-generated constructor stub
	}
}
