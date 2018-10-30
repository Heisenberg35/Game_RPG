/**
 * 
 */
package com.imie.gamerpg.manager;

import java.util.ArrayList;
import com.imie.gamerpg.database.contract.ArmeContract;
import com.imie.gamerpg.database.contract.ArmureContract;
import com.imie.gamerpg.database.dao.DAOManager;
import com.imie.gamerpg.database.dto.ArmeDTO;
import com.imie.gamerpg.database.dto.ArmureDTO;
import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.arme.ArmeMagique;
import com.imie.gamerpg.entity.arme.ArmeMixte;
import com.imie.gamerpg.entity.arme.ArmePhysique;
import com.imie.gamerpg.entity.armure.Armure;
import com.imie.gamerpg.entity.armure.ArmureMagique;
import com.imie.gamerpg.entity.armure.ArmureMixte;
import com.imie.gamerpg.entity.armure.ArmurePhysique;
import com.imie.gamerpg.entity.defaultcharacters.DefaultBarbare;
import com.imie.gamerpg.entity.defaultcharacters.DefaultFighter;
import com.imie.gamerpg.entity.defaultcharacters.DefaultMagicien;
import com.imie.gamerpg.entity.defaultcharacters.DefaultPaladin;
import com.imie.gamerpg.entity.donjon.Donjon;
import com.imie.gamerpg.entity.donjon.Etage;
import com.imie.gamerpg.entity.personnage.Hero;
import com.imie.gamerpg.entity.personnage.Monstre;
import com.imie.gamerpg.utils.ScannerProvider;

/**
 * @author Fabrice
 *
 */
public class Manager {

	private ArrayList<Hero> heros;
	private ArrayList<Monstre> monstres;
	private ArrayList<Arme> armes;
	private ArrayList<Armure> armures;
	private Donjon donjon;

	/**
	 * Constructeur manager
	 */
	public Manager() {
		this.heros = new ArrayList<Hero>();
		this.monstres = new ArrayList<Monstre>();
		this.armes = new ArrayList<Arme>();
		this.armures = new ArrayList<Armure>();
		this.donjon = new Donjon();
	}

	/**
	 * Permet de créer les héros de l'Array Hero
	 * 
	 * @param nb
	 */
	public void add_to_hero() {
		int temp = 0;
		Hero character = new Hero();

		System.out.println("Entre le nom de ton personnage (max 32 caractères)");
		do {
			character.setNom(ScannerProvider.getInstance().nextString());
			if (character.getNom().length() == 0 || character.getNom().length() >= 32)
				System.out.println("Mouais, un peu étrange ton nom quand même, donnes en un autre !");
		} while (character.getNom().length() != 0 && character.getNom().length() <= 32);

		System.out.println("Entre les HPs de ton héros (entre 1 et 10)");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp <= 0)
					System.out.println("C'est pas Walking Dead ici, tu peux pas créer de zombie");
				else if (temp > 10) {
					System.out.println("Bien essayé Antoine, mais c'est 10 HP max donc je set la valeur à 10 d'office ;)");
					temp = 10;
				}
			} else
				System.out.println("T'as été bercé trop près du mur ?");
		} while (temp <= 0);
		character.setPtsVie(temp);
		temp = 0;

		System.out.println("Entre les points d'action de ton personnage (entre 1 et 6)");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp <= 0)
					System.out.println("C'est pas la jungle ici, tu peux pas créer de paresseux");
				else if (temp > 10) {
					System.out
							.println("Bien essayé Antoine, mais c'est 6 PA max donc je set la valeur à 6 d'office ;)");
					temp = 6;
				}
			} else
				System.out.println("La date de péremption de ton cerveau est dépassée ?");
		} while (temp <= 0);
		character.setPtsAction(temp);
		temp = 0;

		System.out.println("Bien ! Tu as maintenant le choix entre 4 classes :");
		System.out.println("1- Paladin\n2- Barbare\n3- Magicien\n4- Sans classe");
		System.out.println("Entre le numéro qui correspond à la classe voulue");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp <= 0 || temp > 4)
					System.out.println("C'est un concept intéressant, mais refusé par le développeur");
			} else
				System.out.println("ArE yOu BrAiNdEaD ? mE tOo ! Xd");
		} while (temp <= 0 || temp > 4);
		switch (temp) {
		case 1:
			character.setClasse(new DefaultPaladin());
			break;
		case 2:
			character.setClasse(new DefaultBarbare());
			break;
		case 3:
			character.setClasse(new DefaultMagicien());
			break;
		case 4:
			character.setClasse(new DefaultFighter());
			break;
		}
		temp = 0;

		// Affichage des armes
		DAOManager<Arme> daoManagerArme = new DAOManager<Arme>();
		ArmeContract armeContract = new ArmeContract();
		ArmeDTO armeDTO = new ArmeDTO();
		ArrayList<Arme> armes = new ArrayList<>();
		armes.addAll(daoManagerArme.selectAll(armeContract, armeDTO));

		Arme choixArme;
		do {
			System.out.println("Choisis l'arme du personnage maintenant");
			for (int i = 0; i < armes.size(); i++) {
				System.out.println(i + 1 + " - " + armes.get(i).getNom() + " || Dégats Physique : "
						+ armes.get(i).getPtsAttaquePhysique() + " || Dégats Magique : "
						+ armes.get(i).getPtsAttaqueMagique() + " || Points d'action : " + armes.get(i).getPtsAction());

			}

			do {
				if (ScannerProvider.getInstance().hasNextInt()) {
					temp = ScannerProvider.getInstance().NextInt();
					if (temp < 1 || temp > 13)
						System.out.println("Test déjà vérifié et jugé invalide, try harder !");
				} else
					System.out.println("T'as toujours pas compris que tu nous ferait pas planter ?");
			} while (temp < 1 || temp > 13);

			// Need vérification de si l'arme est équipable avec le isEquipable
			if (armes.get(temp - 1).getPtsAttaqueMagique() == 0) {
				choixArme = new ArmePhysique(armes.get(temp - 1).getNom(), armes.get(temp - 1).getPtsAttaquePhysique(),
						armes.get(temp - 1).getPtsAttaqueMagique(), armes.get(temp - 1).getPtsAction());
			} else if (armes.get(temp - 1).getPtsAttaquePhysique() == 0) {
				choixArme = new ArmeMagique(armes.get(temp - 1).getNom(), armes.get(temp - 1).getPtsAttaquePhysique(),
						armes.get(temp - 1).getPtsAttaqueMagique(), armes.get(temp - 1).getPtsAction());
			} else {
				choixArme = new ArmeMixte(armes.get(temp - 1).getNom(), armes.get(temp - 1).getPtsAttaquePhysique(),
						armes.get(temp - 1).getPtsAttaqueMagique(), armes.get(temp - 1).getPtsAction());
			}
		} while (!(character.getClasse().isEquipable(choixArme)));

		// Need assignation de l'arme
		character.setArme(choixArme);

		temp = 0;

		// Affichage des armures
		DAOManager<Armure> daoManagerArmure = new DAOManager<Armure>();
		ArmureContract armureContract = new ArmureContract();
		ArmureDTO armureDTO = new ArmureDTO();
		ArrayList<Armure> armures = new ArrayList<>();
		armures.addAll(daoManagerArmure.selectAll(armureContract, armureDTO));

		Armure choixArmure;
		do {
			System.out.println("Last but not least, l'armure");

			for (int i = 0; i < armures.size(); i++) {
				System.out.println(i + 1 + " - " + armures.get(i).getNom() + " || Absorption Physique : "
						+ armures.get(i).getPtsArmurePhysique() + " || Absorption Magique : "
						+ armures.get(i).getPtsArmureMagique());
			}

			do {
				if (ScannerProvider.getInstance().hasNextInt()) {
					temp = ScannerProvider.getInstance().NextInt();
					if (temp < 1 || temp > 12)
						System.out.println("Your error is in another castle !");
				} else
					System.out.println("404 int not found");
			} while (temp < 1 || temp > 12);
			// Need vérification de si l'armure est équipable avec le isEquipable
			if (armures.get(temp - 1).getPtsArmureMagique() == 0) {
				choixArmure = new ArmurePhysique(armures.get(temp - 1).getNom(),
						armures.get(temp - 1).getPtsArmurePhysique(), armures.get(temp - 1).getPtsArmureMagique());
			} else if (armures.get(temp - 1).getPtsArmurePhysique() == 0) {
				choixArmure = new ArmureMagique(armures.get(temp - 1).getNom(),
						armures.get(temp - 1).getPtsArmurePhysique(), armures.get(temp - 1).getPtsArmureMagique());
			} else {
				choixArmure = new ArmureMixte(armures.get(temp - 1).getNom(),
						armures.get(temp - 1).getPtsArmurePhysique(), armures.get(temp - 1).getPtsArmureMagique());
			}

		} while (!(character.getClasse().isEquipable(choixArmure)));
		// Need assignation de l'armure
		character.setArmure(choixArmure);
		this.heros.add(character);
	}

	public void add_to_monster() {
		int temp = 0;
		Monstre character = new Monstre();

		System.out.println("Entre le nom de ton personnage (max 32 caractères)");
		do {
			character.setNom(ScannerProvider.getInstance().nextString());
			if (character.getNom().length() == 0 || character.getNom().length() >= 32)
				System.out.println("Mouais, un peu étrange ton nom quand même, donnes en un autre !");
			ScannerProvider.getInstance().nextLine();
		} while (character.getNom().length() != 0 && character.getNom().length() <= 32);

		System.out.println("Entre les HPs de ton héros (entre 1 et 10)");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp <= 0)
					System.out.println("C'est pas Walking Dead ici, tu peux pas créer de zombie");
				else if (temp > 10) {
					System.out.println(
							"Bien essayé Antoine, mais c'est 10 HP max donc je set la valeur à 10 d'office ;)");
					temp = 10;
				}
			} else
				System.out.println("T'as été bercé trop près du mur ?");
		} while (temp <= 0);
		character.setPtsVie(temp);
		temp = 0;

		System.out.println("Entre les points d'action de ton personnage (entre 1 et 6)");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp <= 0)
					System.out.println("C'est pas la jungle ici, tu peux pas créer de paresseux");
				else if (temp > 10) {
					System.out
							.println("Bien essayé Antoine, mais c'est 6 PA max donc je set la valeur à 6 d'office ;)");
					temp = 6;
				}
			} else
				System.out.println("La date de péremption de ton cerveau est dépassée ?");
		} while (temp <= 0);
		temp = 0;

		System.out.println("Bien ! Tu as maintenant le choix entre 4 classes :");
		System.out.println("1- Paladin\n2- Barbare\n3- Magicien\n4- Sans classe");
		System.out.println("Entre le numéro qui correspond à la classe voulue");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp <= 0 || temp > 4)
					System.out.println("C'est un concept intéressant, mais refusé par le développeur");
			} else
				System.out.println("ArE yOu BrAiNdEaD ? mE tOo ! (:");
		} while (temp <= 0 && temp > 4);
		switch (temp) {
		case 1:
			character.setClasse(new DefaultPaladin());
			break;
		case 2:
			character.setClasse(new DefaultBarbare());
			break;
		case 3:
			character.setClasse(new DefaultMagicien());
			break;
		case 4:
			character.setClasse(new DefaultFighter());
			break;
		}
		temp = 0;

		// Affichage des armes
		System.out.println("Choisis l'arme du personnage maintenant");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp <= 0 || temp > 13)
					System.out.println("Test déjà vérifié et jugé invalide, try harder !");
			} else
				System.out.println("T'as toujours pas compris que tu nous ferait pas planter ?");
		} while (temp <= 0 && temp > 13);
		// Need vérification de si l'arme est équipable avec le isEquipable
		// Need assignation de l'arme
		temp = 0;

		// Affichage des armes
		System.out.println("Last but not least, l'armure");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp <= 0 || temp > 13)
					System.out.println("Your error is in another castle !");
			} else
				System.out.println("404 int not found");
		} while (temp <= 0 && temp > 12);
		// Need vérification de si l'armure est équipable avec le isEquipable
		// Need assignation de l'armure

		this.monstres.add(character);
	}

	public void history_mode() {
	}

	public void free_mode() {
		int i = 0;

		// Récupération du nom du donjon
		System.out.println("Quel sera le nom de ton donjon ?");
		this.donjon.setName(ScannerProvider.getInstance().nextString());
		
		// Récupération du nombre de héros
		System.out.println("Entre le nombre de héros (maximum 10)");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				i = ScannerProvider.getInstance().NextInt();
				if (i <= 0)
					System.out.println("T'as du temps à perdre à donner un mauvais chiffre ?");
				else if (i > 10) {
					System.out.println("Tu t'es cru malin ? BAM sanction, j'te redescends à 10.");
					i = 10;
				}
			} else
				System.out.println("T'es mal partit pour gagner le million toi");
		} while (i <= 0);

		// Création des héros
		for (int test = 0; test < i; test++) {
			add_to_hero();
		}
		i = 0;

		// Récupération du nombre d'étages du donjon
		System.out.println("Entre le nombre d'étages (maximum 3)");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				i = ScannerProvider.getInstance().NextInt();
				if (i <= 0)
					System.out.println("T'as du temps à perdre à donner un mauvais chiffre ?");
				else if (i > 3) {
					System.out.println("Tu t'es cru malin ? BAM sanction, j'te redescends à 3.");
					i = 3;
				}
			} else
				System.out.println("T'es mal partit pour gagner le million toi");
		} while (i <= 0);
		this.donjon.setNb_etage(i);

		// Récupération du nombre d'étages et création des étages
		for (int j = 0; j < i; j++) {
			this.donjon.getEtage().add(new Etage(j));
			System.out.println("Entre le nombre d'ennemis de l'étage " + (j + 1));
			do {
				if (ScannerProvider.getInstance().hasNextInt()) {
					i = ScannerProvider.getInstance().NextInt();
					if (i <= 0)
						System.out.println("T'as du temps à perdre à donner un mauvais chiffre ?");
					else if (i > 10) {
						System.out.println("Tu t'es cru malin ? BAM sanction, j'te redescends à 10.");
						i = 10;
					}
				} else
					System.out.println("T'es mal partit pour gagner le million toi");
			} while (i <= 0);
			
			// Création des monstres de l'étage
			for (int test = 0; test < i; test++) {
				add_to_monster();
			}
			System.out.println("Création de l'étage " + j + " terminé.");
		}

		// Appel de la fonction combat du donjon
	}

	/**
	 * Menu du jeu
	 */
	public void menu() {
		int temp = 0;
		boolean continue_game = true;

		System.out.println("---------- Menu du jeu ----------");
		System.out.println("1 - Mode Histoire");
		System.out.println("2 - Mode Libre");
		System.out.println("3 - Quitter le jeu");
		while (continue_game) {
			if (ScannerProvider.getInstance().hasNextInt())
				temp = ScannerProvider.getInstance().NextInt();
			if (temp == 1)
				history_mode();
			else if (temp == 2)
				free_mode();
			else if (temp == 3)
				continue_game = false;
			else
				System.out.println("Programme pas être cassé toi entrer valeur correcte BIIIIIP");
		}
	}
}
