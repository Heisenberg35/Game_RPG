/**
 * 
 */
package com.imie.gamerpg.entity.donjon;

import java.util.ArrayList;

import com.imie.gamerpg.entity.personnage.Hero;
import com.imie.gamerpg.entity.personnage.Monstre;

/**
 * @author Fabrice
 *
 */
public class Donjon {

	private ArrayList<Etage> etage;
	private int nb_etage;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Donjon() {}
	
	public void aff_fight(ArrayList<Monstre> monstre, ArrayList<Hero> heros) {
		int temp = 0;
		
		if (monstre.size() > heros.size())
			temp = monstre.size();
		else
			temp = heros.size();
		System.out.println("Héros                                                      Ennemis");
		
		for (int i = 1; i <= temp; i++) {

			System.out.print("Nom : " + heros.get(i).getNom());
			for (int z = 1; z <= (32 - heros.get(i).getNom().length()); z++)
				System.out.print(" ");
			System.out.println("Nom : " + monstre.get(i).getNom());
			
			System.out.print("PVs : " + heros.get(i).getPtsVie() + " PAs : " + heros.get(i).getPtsAction());
			for (int z = 1; z <= 32; z++)
				System.out.print(" ");
			System.out.println("PVs : " + monstre.get(i).getPtsVie() + " PAs : " + monstre.get(i).getPtsAction());
			
			System.out.print("Classe : " + heros.get(i).getClasse());
			for (int z = 1; z <= 32; z++)
				System.out.print(" ");
			System.out.println("Classe : " + monstre.get(i).getClasse());
			
			System.out.print("Arme : " + heros.get(i).getArme());
			for (int z = 1; z <= 32; z++)
				System.out.print(" ");
			System.out.println("Arme : " + monstre.get(i).getArme());
			
			System.out.print("Armure : " + heros.get(i).getArmure());
			for (int z = 1; z <= 32; z++)
				System.out.print(" ");
			System.out.println("Armure : " + monstre.get(i).getArmure());
		}
	}
	
	public void Combat(ArrayList<Hero> heros) {
		int temp = 0;
		
		System.out.println("Bienvenue dans le donjon \"" + this.name + "\".");
		for (int count = 1; count <= nb_etage; count++) {
			System.out.println("Vous êtes actuellement à l'étage "+ count);
			System.out.println("Une horde de monstres terrifiants arrivent, préparez vous pour le combat !");
			while (count < 69) // Etage et Hero is alive
			{
				aff_fight(this.etage.get(count).getMonstre(), heros);
				temp = 0;
				if (this.etage.get(count).getMonstre().size() > heros.size())
					temp = this.etage.get(count).getMonstre().size();
				else
					temp = heros.size();
				for (int z = 1; z <= temp; z++) { // On a pas parcouru toute la liste
					heros.get(z).getClasse().fight(this.etage.get(count).getMonstre().get(z));
				}
			}
		}
	}
	
}
