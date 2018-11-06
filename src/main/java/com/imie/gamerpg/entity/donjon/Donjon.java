/**
 * 
 */
package com.imie.gamerpg.entity.donjon;

import java.util.ArrayList;
import java.util.Random;

import com.imie.gamerpg.entity.personnage.Hero;
import com.imie.gamerpg.entity.personnage.Monstre;
import com.imie.gamerpg.utils.ScannerProvider;

/**
 * @author Fabrice
 *
 */
public class Donjon {

	private ArrayList<Etage> etage;
	private int nb_etage;
	private String name;
	private Random rand;

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
		this.rand = new Random();
	}
	
	public void aff_fight(ArrayList<Monstre> monstre, ArrayList<Hero> heros) {
		int temp = 0;

		System.out.println("H�ros                                                                                        "
				+ "                                                  Ennemis");
		
		if (monstre.size() > heros.size())
			temp = monstre.size();
		else
			temp = heros.size();
		
		System.out.println("Temp = " + temp + " ; heros_size : "  + heros.size() + " ; monstre_size : " + monstre.size());
		for (int i = 0; i < temp; i++) {

			if (i < heros.size())
				System.out.print("Nom : " + heros.get(i).getNom());
			for (int z = 0; z < 96; z++) 
				System.out.print(" ");
			if (i < monstre.size())
				System.out.println("Nom : " + monstre.get(i).getNom());

			if (i < heros.size())
				System.out.print("PVs : " + heros.get(i).getPtsVie() + " PAs : " + heros.get(i).getPtsAction());
			for (int z = 0; z < 88; z++)
				System.out.print(" ");
			if (i < monstre.size())
				System.out.println("PVs : " + monstre.get(i).getPtsVie() + " PAs : " + monstre.get(i).getPtsAction());

			if (i < heros.size())
				System.out.print("Classe : " + heros.get(i).getClasse().toString());
			for (int z = 1; z <= 88; z++)
				System.out.print(" ");
			if (i < monstre.size())
				System.out.println("Classe : " + monstre.get(i).getClasse().toString());

			if (i < heros.size())
				System.out.print("Arme : " + heros.get(i).getArme());
			for (int z = 1; z <= 32; z++)
				System.out.print(" ");
			if (i < monstre.size())
				System.out.println("Arme : " + monstre.get(i).getArme());

			if (i < heros.size())
				System.out.print("Armure : " + heros.get(i).getArmure());
			for (int z = 1; z <= 32; z++)
				System.out.print(" ");
			if (i < monstre.size())
				System.out.println("Armure : " + monstre.get(i).getArmure());
		}
	}
	
	public int Combat(ArrayList<Hero> heros) {
		int temp = 0;
		int gold = 0;
		int temp_gold = 0;
		int user_choice;
		
		System.out.println("Bienvenue dans le donjon \"" + this.name + "\".");

		// Boucle sur chaque �tage du donjon
		for (int count = 0; count < nb_etage; count++) {
			System.out.println("Vous �tes actuellement � l'�tage "+ (count +1));
			System.out.println("Une horde de monstres terrifiants arrivent, pr�parez vous pour le combat !");
			
			// Boucle du combat de l'�tage
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
					user_choice = 0;
					
					// Tour des h�ros
					if (z < heros.size()) {
						System.out.println("Le h�ros " + heros.get(z).getNom() + " est pr�t � se battre ! Que doit-il faire ?");
						System.out.println("1 - Attaquer\n2 - Se d�fendre\n");
						user_choice = ScannerProvider.getInstance().NextInt();
						
						// Si user attaque
						if (user_choice == 1) {
							
							// Si on a un monstre en face de nous
							if (z <= this.etage.get(count).getMonstre().size()) {
								heros.get(z).getClasse().fight(this.etage.get(count).getMonstre().get(z));
								if (!this.etage.get(count).getMonstre().get(z).isAlive()) {
									temp_gold += rand.nextInt(100);
									System.out.println("Vous avez battu le monstre " + this.etage.get(count).getMonstre().get(z).getNom() + " et gagn� " + temp_gold + " gold");
									gold += temp_gold;
									this.etage.get(count).getMonstre().remove(z);
								}
							}
							
							// Si on a pas de monstre en face on tape le dernier de la liste
							else {
								heros.get(z).getClasse().fight(this.etage.get(count).getMonstre().get(this.etage.get(count).getMonstre().size() -1));
								if (!this.etage.get(count).getMonstre().get(this.etage.get(count).getMonstre().size() -1).isAlive()) {
									temp_gold += rand.nextInt(100);
									System.out.println("Vous avez battu le monstre " + this.etage.get(count).getMonstre().get(this.etage.get(count).getMonstre().size() -1).getNom() + " et gagn� " + temp_gold + " gold");
									gold += temp_gold;
									this.etage.get(count).getMonstre().remove(this.etage.get(count).getMonstre().size() -1);
								}
							}
						}
						
						// Si user d�fend
						else if (user_choice == 2)
							heros.get(z).getClasse().defendre(heros.get(z));
						
						// Si Antoine troll encore
						else
							System.out.println("T'essaies encore ?");
					}
					
					// Tour du monstre
					if (z < this.etage.get(count).getMonstre().size()) {
						System.out.println("Le monstre " + this.etage.get(count).getMonstre().get(z).getNom() + " est pr�t � se battre !");
						user_choice = rand.nextInt(1) + 1;
						
						// Si IA attaque
						if (user_choice == 1) {
							System.out.println("Le monstre attaque !");
							// Si on a un h�ros en face de nous
							if (z <= heros.size()) {
								this.etage.get(count).getMonstre().get(z).getClasse().fight(heros.get(z));
								if (!heros.get(z).isAlive()) {
									System.out.println("Le monstre " + this.etage.get(count).getMonstre().get(z).getNom() + " a battu le h�ros " + heros.get(z).getNom() + " .");
									heros.remove(z);
								}
							}
							
							// Si on a pas de h�ros en face on tape le dernier de la liste
							else {
								this.etage.get(count).getMonstre().get(z).getClasse().fight(heros.get(heros.size() -1));
								if (!heros.get(heros.size() -1).isAlive()) {
									System.out.println("Le monstre " + this.etage.get(count).getMonstre().get(z).getNom() + " a battu le h�ros " + heros.get(heros.size() -1).getNom() + " .");
									heros.remove(heros.size() -1);
								}
							}
						}
						
						// Si l'IA d�fend
						else if (user_choice == 2) {
							System.out.println("Le monstre se d�fend !");
							heros.get(z).getClasse().defendre(heros.get(z));
						}
						
						// Si Antoine troll encore
						else
							System.out.println("T'essaies encore ?");
					}
					// Gestion fin de l'Array monstre ou h�ros
					}
				}

			
			// Condition pour v�rifier si l'�quipe de h�ros est mort ou pas
			if (heros.size() == 0) {
				System.out.println("Votre �quipe de z�ros s'envole vers d'autres cieux.");
				count = nb_etage;
				gold = 0;
			}
			else
				System.out.println("Votre �quipe est victorieuse !");
		}
		return gold;
	}
	
}
