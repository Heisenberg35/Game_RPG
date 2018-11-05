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

	private DAOManager<Arme> daoManagerArme;
	private DAOManager<Armure> daoManagerArmure;
	private ArmeContract armeContract;
	private ArmureContract armureContract;
	private ArmeDTO armeDTO;
	private ArmureDTO armureDTO;
	private ArrayList<Hero> heros;
	private ArrayList<Arme> armes;
	private ArrayList<Armure> armures;
	private Donjon donjon;

	/**
	 * Constructeur manager
	 */
	public Manager() {
		this.daoManagerArme = new DAOManager<Arme>();
		this.armeContract = new ArmeContract();
		this.armeDTO = new ArmeDTO();
		this.armes = new ArrayList<Arme>();
		this.armes.addAll(daoManagerArme.selectAll(armeContract, armeDTO));
		this.daoManagerArmure = new DAOManager<Armure>();
		this.armureContract = new ArmureContract();
		this.armureDTO = new ArmureDTO();
		this.armures = new ArrayList<>();
		this.armures.addAll(daoManagerArmure.selectAll(armureContract, armureDTO));
		this.heros = new ArrayList<Hero>();
		this.donjon = new Donjon();
	}

	/**
	 * 
	 * @return
	 */
	private Arme get_Arme() {
		int temp = 0;
		// Affichage des armes
		Arme choixArme;
		do {
			System.out.println("Choisis l'arme du personnage maintenant");
			for (int i = 0; i < armes.size(); i++) {
				System.out.println(i + 1 + " - " + armes.get(i).getNom() + " || Dégats Physique : "
						+ armes.get(i).getPtsAttaquePhysique() + " || Dégats Magique : "
						+ armes.get(i).getPtsAttaqueMagique() + " || Points d'action : " + armes.get(i).getPtsAction());

			}

			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp < 1 || temp > 13)
					System.out.println("Test déjà vérifié et jugé invalide, try harder !");
			} else
				System.out.println("T'as toujours pas compris que tu nous ferait pas planter ?");
		} while (temp < 1 || temp > 13);

		// En fonction de l'arme choisie, on détermine si celle-ci est une arme
		// physique, magique ou mixte
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

		return choixArme;
	}

	/**
	 * 
	 * @return
	 */
	private Armure get_Armure() {
		int temp = 0;
		// Affichage des armures
		Armure choixArmure;
		do {
			System.out.println("Last but not least, l'armure");

			for (int i = 0; i < armures.size(); i++) {
				System.out.println(i + 1 + " - " + armures.get(i).getNom() + " || Absorption Physique : "
						+ armures.get(i).getPtsArmurePhysique() + " || Absorption Magique : "
						+ armures.get(i).getPtsArmureMagique());
			}

			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp < 1 || temp > 12)
					System.out.println("Your error is in another castle !");
			} else
				System.out.println("404 int not found");
		} while (temp < 1 || temp > 12);

		// En fonction de l'armure choisie, on détermine si celle-ci est une armure
		// physique, magique ou mixte
		if (armures.get(temp - 1).getPtsArmureMagique() == 0) {
			choixArmure = new ArmurePhysique(armures.get(temp - 1).getNom(),
					armures.get(temp - 1).getPtsArmurePhysique(), armures.get(temp - 1).getPtsArmureMagique());
		} else if (armures.get(temp - 1).getPtsArmurePhysique() == 0) {
			choixArmure = new ArmureMagique(armures.get(temp - 1).getNom(),
					armures.get(temp - 1).getPtsArmurePhysique(), armures.get(temp - 1).getPtsArmureMagique());
		} else {
			choixArmure = new ArmureMixte(armures.get(temp - 1).getNom(), armures.get(temp - 1).getPtsArmurePhysique(),
					armures.get(temp - 1).getPtsArmureMagique());
		}

		return choixArmure;
	}

	private int get_int_with_max(int max) {
		int temp = 0;

		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				temp = ScannerProvider.getInstance().NextInt();
				if (temp <= 0)
					System.out.println("T'as du temps à perdre à donner un mauvais chiffre ?");
				else if (temp > max) {
					System.out.println("Tu t'es cru malin ? BAM sanction, j'te redescends à 10.");
					temp = max;
				}
			} else
				System.out.println("T'es mal partit pour gagner le million toi");
		} while (temp <= 0);
		return temp;
	}

	private String get_char_name() {
		String name = new String();

		System.out.println("Entre le nom de ton personnage (max 32 caractères)");
		do {
			name = ScannerProvider.getInstance().nextLine();
			if (name.length() == 0 || name.length() >= 32) {
				System.out.println("Mouais, un peu étrange ton nom quand même, donnes en un autre !");
			}
		} while (!(name.length() != 0 && name.length() <= 32));
		return name;
	}

	private int get_char_HP() {
		int hp = 0;

		System.out.println("Entre les HPs de ton héros (entre 1 et 10)");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				hp = ScannerProvider.getInstance().NextInt();
				if (hp <= 0)
					System.out.println("C'est pas Walking Dead ici, tu peux pas créer de zombie");
				else if (hp > 10) {
					System.out.println(
							"Bien essayé Antoine, mais c'est 10 HP max donc je set la valeur à 10 d'office ;)");
					hp = 10;
				}
			} else
				System.out.println("T'as été bercé trop près du mur ?");
		} while (hp <= 0);
		return hp;
	}

	private int get_char_PA() {
		int pa = 0;

		System.out.println("Entre les points d'action de ton personnage (entre 1 et 6)");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				pa = ScannerProvider.getInstance().NextInt();
				if (pa <= 0)
					System.out.println("C'est pas la jungle ici, tu peux pas créer de paresseux");
				else if (pa > 10) {
					System.out
							.println("Bien essayé Antoine, mais c'est 6 PA max donc je set la valeur à 6 d'office ;)");
					pa = 6;
				}
			} else
				System.out.println("La date de péremption de ton cerveau est dépassée ?");
		} while (pa <= 0);
		return pa;
	}

	private DefaultFighter get_char_class() {
		DefaultFighter classe = new DefaultFighter();
		int temp = 0;

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
			classe = new DefaultPaladin();
			break;
		case 2:
			classe = new DefaultBarbare();
			break;
		case 3:
			classe = new DefaultMagicien();
			break;
		}
		return classe;
	}

	public void history_mode() {
	}

	public void free_mode() {
		int i = 0;

		// Récupération du nom du donjon
		System.out.println("Quel sera le nom de ton donjon ?");
		this.donjon.setName(ScannerProvider.getInstance().nextLine());

		// Récupération du nombre de héros
		System.out.println("Entre le nombre de héros (maximum 10)");
		i = get_int_with_max(10);

		// Création des héros
		for (int count = 0; count < i; count++) {
			this.heros.add(new Hero(get_char_name(), get_char_HP(), get_char_PA(), get_char_class()));
			// Choisir une arme
			Arme choixArme = get_Arme();
			// Vérification que l'arme choisie correspond à la classe
			while (!(this.heros.get(count).getClasse().isEquipable(choixArme))) {
				System.out.println(
						"L'arme choisie ne correspond pas à la classe du personnage, veuillez re-choisir une arme correspondante à la classe du personnage ");
				choixArme = get_Arme();
			}
			// Attribution de l'arme choisie au personnage
			this.heros.get(count).setArme(choixArme);
			// Choisir une armure
			Armure choixArmure = get_Armure();
			// Vérification que l'armure choisie correspond à la classe
			while (!(this.heros.get(count).getClasse().isEquipable(choixArmure))) {
				System.out.println(
						"L'armure choisie ne correspond pas à la classe du personnage, veuillez re-choisir une armure correspondante à la classe du personnage ");
				choixArmure = get_Armure();
			}
			// Attribution de l'armure choisie au personnage
			this.heros.get(count).setArmure(choixArmure);
		}
		i = 0;

		// Récupération du nombre d'étages du donjon
		System.out.println("Entre le nombre d'étages (maximum 3)");
		i = get_int_with_max(3);
		this.donjon.setNb_etage(i);

		// Récupération du nombre de monstre et création des étages
		for (int j = 0; j < donjon.getNb_etage(); j++) {
			this.donjon.getEtage().add(new Etage(j));
			i = 0;

			System.out.println("Entre le nombre d'ennemis de l'étage " + (j + 1));
			i = get_int_with_max(10);

			// Création des monstres de l'étage
			for (int count = 0; count < i; count++) {
				this.donjon.getEtage().get(j).getMonstre()
						.add(new Monstre(get_char_name(), get_char_HP(), get_char_PA(), get_char_class()));
				// Choisir une arme
				Arme choixArme = get_Arme();
				// Vérification que l'arme choisie correspond à la classe
				while (!(this.donjon.getEtage().get(j).getMonstre().get(count).getClasse().isEquipable(choixArme))) {
					System.out.println(
							"L'arme choisie ne correspond pas à la classe du monstre, veuillez re-choisir une arme correspondante à la classe du personnage ");
					choixArme = get_Arme();
				}
				// Attribution de l'armure choisie au personnage
				this.donjon.getEtage().get(j).getMonstre().get(count).setArme(choixArme);
				// Choisir une armure
				Armure choixArmure = get_Armure();
				// Vérification que l'armure choisie correspond à la classe
				while (!(this.donjon.getEtage().get(j).getMonstre().get(count).getClasse().isEquipable(choixArmure))) {
					System.out.println(
							"L'armure choisie ne correspond pas à la classe du personnage, veuillez re-choisir une armure correspondante à la classe du personnage ");
					choixArmure = get_Armure();
				}
				// Attribution de l'armure choisie au personnage
				this.donjon.getEtage().get(j).getMonstre().get(count).setArmure(choixArmure);
			}
			System.out.println("Création de l'étage " + j + " terminé.");
		}
		donjon.Combat(heros);
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
