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
	private int nbEtage;
	private String name;
	private Random rand;

	public Donjon() {
		this.etage = new ArrayList<Etage>();
		this.rand = new Random();
	}

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

	public int getNbEtage() {
		return nbEtage;
	}

	public void setNbEtage(int nbEtage) {
		this.nbEtage = nbEtage;
	}

	/**
	 * Permet d'afficher le combat de l'étage en cours
	 * @param monstre
	 * @param heros
	 */
	public void aff_fight(ArrayList<Monstre> monstre, ArrayList<Hero> heros) {
		int temp = 0;

		System.out.println("Héros                                                       "
				+ "                                 "
				+ "                                                  Ennemis");

		if (monstre.size() > heros.size()) {
			temp = monstre.size();
		} else {
			temp = heros.size();
		}

		System.out.println("Temp = " + temp + " ; heros_size : "
		+ heros.size() + " ; monstre_size : " + monstre.size());
		for (int i = 0; i < temp; i++) {

			if (i < heros.size()) {
				System.out.print("Nom : " + heros.get(i).getNom());
			}
			for (int z = 0; z < 96; z++) {
				System.out.print(" ");
			}
			if (i < monstre.size()) {
				System.out.print("Nom : " + monstre.get(i).getNom());
			}
			System.out.print('\n');

			if (i < heros.size()) {
				System.out.print("PVs : " + heros.get(i).getPtsVie() + " PAs : "
			+ heros.get(i).getPtsAction());
			}
			for (int z = 0; z < 88; z++) {
				System.out.print(" ");
			}
			if (i < monstre.size()) {
				System.out.print("PVs : " + monstre.get(i).getPtsVie() + " PAs : "
			+ monstre.get(i).getPtsAction());
			}
			System.out.print('\n');

			if (i < heros.size()) {
				System.out.print("Classe : " + heros.get(i).getClasse().toString());
			}
			for (int z = 1; z <= 88; z++) {
				System.out.print(" ");
			}
			if (i < monstre.size()) {
				System.out.print("Classe : " + monstre.get(i).getClasse().toString());
			}
			System.out.print('\n');

			if (i < heros.size()) {
				System.out.print("Arme : " + heros.get(i).getArme());
			}
			for (int z = 1; z <= 32; z++) {
				System.out.print(" ");
			}
			if (i < monstre.size()) {
				System.out.print("Arme : " + monstre.get(i).getArme());
			}
			System.out.print('\n');

			if (i < heros.size()) {
				System.out.print("Armure : " + heros.get(i).getArmure());
			}
			for (int z = 1; z <= 32; z++) {
				System.out.print(" ");
			}
			if (i < monstre.size()) {
				System.out.print("Armure : " + monstre.get(i).getArmure());
			}
			System.out.print('\n');
		}
	}

	/**
	 * Fonction qui fait combattre l'Array d'héros dans un donjon
	 * @param heros
	 * @return
	 */
	public int combat(ArrayList<Hero> heros) {
		int temp = 0;
		int gold = 0;
		int tempGold = 0;
		int userChoice;

		System.out.println("Bienvenue dans le donjon \"" + this.name + "\".");

		// Boucle sur chaque étage du donjon
		for (int count = 0; count < nbEtage; count++) {
			System.out.println("Vous êtes actuellement à l'étage " + (count + 1));
			System.out.println("Une horde de monstres terrifiants arrivent, préparez vous pour le combat !");

			// Boucle du combat de l'étage
			while (heros.size() > 0 && this.etage.get(count).getMonstre().size() > 0) {
				aff_fight(this.etage.get(count).getMonstre(), heros);
				temp = 0;
				if (this.etage.get(count).getMonstre().size() > heros.size()) {
					temp = this.etage.get(count).getMonstre().size();
				} else {
					temp = heros.size();
				}

				// Boucle d'attaque
				for (int z = 0; z < temp; z++) { // On a pas parcouru toute la liste
					userChoice = 0;

					// Tour des héros
					if (z < heros.size() && this.etage.get(count).getMonstre().size() > 0) {
						System.out.println(
								"Le héros " + heros.get(z).getNom() + " est prêt à se battre ! Que doit-il faire ?");
						System.out.println("1 - Attaquer\n2 - Se défendre\n");
						userChoice = ScannerProvider.getInstance().NextInt();

						// Si user attaque
						if (userChoice == 1) {

							// Si on a un monstre en face de nous
							if (z <= this.etage.get(count).getMonstre().size()) {
								heros.get(z).getClasse().fight(this.etage.get(count).getMonstre().get(z));
								if (!this.etage.get(count).getMonstre().get(z).isAlive()) {
									tempGold += rand.nextInt(100);
									System.out.println("Vous avez battu le monstre "
											+ this.etage.get(count).getMonstre().get(z).getNom() + " et gagné "
											+ tempGold + " gold");
									gold += tempGold;
									this.etage.get(count).getMonstre().remove(z);
								}
							} else { // Si on a pas de monstre en face on tape le dernier de la liste
								heros.get(z).getClasse().fight(this.etage.get(count).getMonstre()
										.get(this.etage.get(count).getMonstre().size() - 1));
								if (!this.etage.get(count).getMonstre()
										.get(this.etage.get(count).getMonstre().size() - 1).isAlive()) {
									tempGold += rand.nextInt(100);
									System.out.println("Vous avez battu le monstre "
											+ this.etage.get(count).getMonstre()
													.get(this.etage.get(count).getMonstre().size() - 1).getNom()
											+ " et gagné " + tempGold + " gold");
									gold += tempGold;
									this.etage.get(count).getMonstre()
											.remove(this.etage.get(count).getMonstre().size() - 1);
								}
							}
						} else if (userChoice == 2) { // Si user défend
							heros.get(z).getClasse().defendre(heros.get(z));
						} else { // Si Antoine troll encore
							System.out.println("T'essaies encore ?");
						}
					}

					// Tour du monstre
					if (z < this.etage.get(count).getMonstre().size() && heros.size() > 0) {
						System.out.println("Le monstre " + this.etage.get(count).getMonstre().get(z).getNom()
								+ " est prêt à se battre !");
						userChoice = rand.nextInt(1) + 1;

						// Si IA attaque
						if (userChoice == 1) {
							System.out.println("Le monstre attaque !");
							// Si on a un héros en face de nous
							if (z <= heros.size()) {
								this.etage.get(count).getMonstre().get(z).getClasse().fight(heros.get(z));
								if (!heros.get(z).isAlive()) {
									System.out
											.println("Le monstre " + this.etage.get(count).getMonstre().get(z).getNom()
													+ " a battu le héros " + heros.get(z).getNom() + " .");
									heros.remove(z);
								}
							} else { // Si on a pas de héros en face on tape le dernier de la liste
								this.etage.get(count).getMonstre().get(z).getClasse()
										.fight(heros.get(heros.size() - 1));
								if (!heros.get(heros.size() - 1).isAlive()) {
									System.out.println("Le monstre "
											+ this.etage.get(count).getMonstre().get(z).getNom() + " a battu le héros "
											+ heros.get(heros.size() - 1).getNom() + " .");
									heros.remove(heros.size() - 1);
								}
							}
						} else if (userChoice == 2) { // Si l'IA défend
							System.out.println("Le monstre se défend !");
							heros.get(z).getClasse().defendre(heros.get(z));
						} else { // Si Antoine troll encore
							System.out.println("T'essaies encore ?");
						}
					}
				}
			}

			// Condition pour vérifier si l'équipe de héros est mort ou pas
			if (heros.size() == 0) {
				System.out.println("Votre équipe de zéros s'envole vers d'autres cieux.");
				count = nbEtage;
				gold = 0;
			} else {
				System.out.println("Votre équipe est victorieuse !");
			}
		}
		return gold;
	}
}
