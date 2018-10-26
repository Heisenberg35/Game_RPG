/**
 * 
 */
package com.imie.gamerpg.manager;

import java.util.ArrayList;
import com.imie.gamerpg.entity.arme.ArmeMagique;
import com.imie.gamerpg.entity.arme.ArmeMixte;
import com.imie.gamerpg.entity.arme.ArmePhysique;
import com.imie.gamerpg.entity.armure.ArmureMagique;
import com.imie.gamerpg.entity.armure.ArmureMixte;
import com.imie.gamerpg.entity.armure.ArmurePhysique;
import com.imie.gamerpg.entity.defaultcharacters.DefaultFighter;
import com.imie.gamerpg.entity.personnage.Hero;
import com.imie.gamerpg.entity.personnage.Monstre;
import com.imie.gamerpg.utils.ScannerProvider;

/**
 * @author Fabrice
 *
 */
public class Manager {

	ArrayList<Hero> heros;
	ArrayList<Monstre> monstres;

	/**
	 * Constructeur manager
	 */
	public Manager() {
		super();
		this.heros = new ArrayList<Hero>();
		this.monstres = new ArrayList<Monstre>();
	}

	/**
	 * Permet de créer les héros de l'Array Hero
	 * @param nb
	 * @param heros2 
	 */
	public void add_to_list(int nb) {
		int temp = 0;
		for (int i = 0; i <= nb; i++)
		{
			Hero character = new Hero();
			System.out.println("Entre le nom de ton héros");
			character.setNom(ScannerProvider.getInstance().nextString());
			System.out.println("Entre les HPs de ton héros entre 1 et 10");
			do {
				if (ScannerProvider.getInstance().hasNextInt()) {
					temp = ScannerProvider.getInstance().NextInt();
					if (temp <= 0)
						System.out.println("C'est pas Walking Dead ici, tu peux pas créer de zombie");
					else if (temp > 10) {
						System.out.println("Bien essayé Antoine, mais c'est 10 HP max donc je set la valeur à 10 d'office ;)");
						temp = 10;
					}
				}
				else
					System.out.println("T'as été bercé trop près du mur ?");
			} while (temp <= 0);
			character.setPtsVie(temp);
			temp = 0;
			System.out.println("Entre les points d'action de ton héros entre 1 et 6");
			do {
				if (ScannerProvider.getInstance().hasNextInt()) {
					temp = ScannerProvider.getInstance().NextInt();
					if (temp <= 0)
						System.out.println("C'est pas la jungle ici, tu peux pas créer de paresseux");
					else if (temp > 10) {
						System.out.println("Bien essayé Antoine, mais c'est 6 PA max donc je set la valeur à 6 d'office ;)");
						temp = 6;
					}
				}
				else
					System.out.println("La date de péremption de ton cerveau est dépassée ?");
			} while (temp <= 0);
		}
		
		
		
//		Hero hero = new Hero("leBarbare", 100, 10, new ArmePhysique("epée", 20, 0, 5),
//				new ArmurePhysique("armureMaille", 0, 10), new DefaultFighter());
//		Hero hero2 = new Hero("leMagicien", 100, 10, new ArmeMagique("baguette", 0, 15, 8),
//				new ArmureMagique("armureTissu", 10, 0), new DefaultFighter());
//		Hero hero3 = new Hero("lePaladin", 100, 10, new ArmeMixte("epée de flamme", 10, 10, 5),
//				new ArmureMixte("armureGlaciale", 5, 5), new DefaultFighter());
//		Hero hero4 = new Hero("leFighter", 100, 10, new ArmeMixte("lame d'acier", 10, 10, 5),
//				new ArmureMixte("armureBlack", 5, 5), new DefaultFighter());
//
//		heros.add(hero);
//		heros.add(hero2);
//		heros.add(hero3);
//		heros.add(hero4);
	}

	/**
	 * 
	 */
	public void addMonstre(int nb) {
		Monstre monstre = new Monstre("leMonstreBarbare", 100, 10, new ArmePhysique("epée", 20, 0, 5),
				new ArmurePhysique("armureMaille", 0, 10), new DefaultFighter());
		Monstre monstre2 = new Monstre("leMonstreMagicien", 100, 10, new ArmeMagique("baguette", 0, 15, 8),
				new ArmureMagique("armureTissu", 10, 0), new DefaultFighter());
		Monstre monstre3 = new Monstre("leMonstrePaladin", 100, 10, new ArmeMixte("epée de flamme", 10, 10, 5),
				new ArmureMixte("armureGlaciale", 5, 5), new DefaultFighter());
		Monstre monstre4 = new Monstre("leMonstreFighter", 100, 10, new ArmeMixte("lame d'acier", 10, 10, 5),
				new ArmureMixte("armureBlack", 5, 5), new DefaultFighter());

		monstres.add(monstre);
		monstres.add(monstre2);
		monstres.add(monstre3);
		monstres.add(monstre4);
	}

	public void init() {
		System.out.println("AHAH NON TU RENTRES RIEN USER _|_");
		this.heros.add(null);
		this.monstres.add(null);
		
	}
	
	public void start() {}

	public void game() {}
	
	public void history_mode() {}
	
	public void free_mode() {
		int i = 0;

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
			}
			else
				System.out.println("T'es mal partit pour gagner le million toi");
		} while (i <= 0);
		add_to_list(i);
		i = 0;
		System.out.println("Entre le nombre d'ennemis");
		do {
			if (ScannerProvider.getInstance().hasNextInt()) {
				i = ScannerProvider.getInstance().NextInt();
				if (i <= 0)
					System.out.println("T'as du temps à perdre à donner un mauvais chiffre ?");
				else if (i > 10) {
					System.out.println("Tu t'es cru malin ? BAM sanction, j'te redescends à 10.");
					i = 10;
				}
			}
			else
				System.out.println("T'es mal partit pour gagner le million toi");
		} while (i <= 0);
		add_to_list(i);

	}

	/**
	 * 
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
