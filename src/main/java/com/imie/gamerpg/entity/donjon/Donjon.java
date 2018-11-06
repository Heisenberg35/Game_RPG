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

	public ArrayList<Etage> getEtage() {
		return etage;
	}

	public void setEtage(ArrayList<Etage> etage) {
		this.etage = etage;
	}

	public int getNb_etage() {
		return nb_etage;
	}

	public void setNb_etage(int nb_etage) {
		this.nb_etage = nb_etage;
	}

	public Donjon() {
		this.etage = new ArrayList<Etage>();
	}
	
	public void aff_fight(ArrayList<Monstre> monstre, ArrayList<Hero> heros) {
		int temp = 0;
		
		if (monstre.size() > heros.size())
			temp = monstre.size();
		else
			temp = heros.size();
		System.out.println("Héros                                                                                        "
				+ "                                                  Ennemis");
		
		for (int i = 0; i < temp; i++) {

			System.out.print("Nom : " + heros.get(i).getNom());
			for (int z = 0; z < 96; z++) 
				System.out.print(" ");
			System.out.println("Nom : " + monstre.get(i).getNom());
			
			System.out.print("PVs : " + heros.get(i).getPtsVie() + " PAs : " + heros.get(i).getPtsAction());
			for (int z = 0; z < 88; z++)
				System.out.print(" ");
			System.out.println("PVs : " + monstre.get(i).getPtsVie() + " PAs : " + monstre.get(i).getPtsAction());
			
			System.out.print("Classe : " + heros.get(i).getClasse().toString());
			for (int z = 1; z <= 88; z++)
				System.out.print(" ");
			System.out.println("Classe : " + monstre.get(i).getClasse().toString());
			
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

		// Boucle sur chaque étage du donjon
		for (int count = 0; count < nb_etage; count++) {
			System.out.println("Vous êtes actuellement à l'étage "+ (count +1));
			System.out.println("Une horde de monstres terrifiants arrivent, préparez vous pour le combat !");
			
			// Boucle du combat de l'étage
			while (heros.size() > 0 && this.etage.get(count).getMonstre().size() > 0)
			{
				aff_fight(this.etage.get(count).getMonstre(), heros);
				temp = 0;
				if (this.etage.get(count).getMonstre().size() > heros.size())
					temp = this.etage.get(count).getMonstre().size();
				else
					temp = heros.size();
				
				// Boucle d'attaque
				for (int z = 0; z < temp; z++) { // On a pas parcouru toute la liste
					heros.get(z).getClasse().fight(this.etage.get(count).getMonstre().get(z));
					
					// Récupérer la saisie user 1 ou 2 pour attaquer ou défendre
					
					// Ajouter un Rand pour une somme de pos à retourner
				}
			}
			
			// Condition pour vérifier si l'équipe de héros est mort ou pas
			if (heros.size() == 0) {
				System.out.println("Votre équipe de zéros s'envole vers d'autres cieux.");
				count = nb_etage;
			}
			else
				System.out.println("Votre équipe est victorieuse !");
		}
	}
	
}
