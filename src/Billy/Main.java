package Billy;

import java.util.Scanner;

public class Main {
	
	private static Scanner sc = new Scanner (System.in);		
	public static MAP map = new MAP();
	public static Inventory inventaire = new Inventory();
	public static Billy billy = new Billy(3,inventaire,0,0);
	
	
	public static void main (String [] args ) {
		
		ecranTitre();
		
		boolean outgame=false;
		
		billy.getItems().addItemsInInventory(Powerup.ARC);
		
		Display d = new Display(map);
		System.out.println(d);
		
		Move bouger = new Move () ;
		for (int i = 0; i < 130; i++) {
			bouger.moveRight(map);
			bouger.moveMap(map);
		}
		clear();
		
		while (!billy.isDead() && !outgame) {
			d = new Display(map);
			System.out.println(d);
			
			System.out.println("[i]: inventaire. \n[d] [Espace] [Entrée]: avancer.\n[z] [s]: monter / descendre (nécessite et utilise une pioche). \n[q]: quitter\n");
			
			String saisieUtilisateur = sc.nextLine();
			
			if (saisieUtilisateur.equals("") ){
				
				clear();
				bouger.difficulty(billy.getScore());
				bouger.detect(map, billy);
				bouger.moveRight(map);
				bouger.moveMap(map);
				billy.setScore(billy.getScore() + 1);
				bouger.difficulty(billy.getScore());
				
			}else if (saisieUtilisateur.charAt(0)=='d' || saisieUtilisateur.charAt(0)==' ') {
				clear();
				bouger.detect(map, billy);
				bouger.moveRight(map);
				bouger.moveMap(map);
				billy.setScore(billy.getScore() + 1);
				bouger.difficulty(billy.getScore());
			} 
			
			else if (saisieUtilisateur.charAt(0)=='q') {
				clear();

			System.out.println("\n    _");
			System.out.println("   { )_");
			System.out.println("    /  >>   _");
			System.out.println("   / /\\°\\__/.°   Vous avez fait demi-tour!!");
			System.out.println("  °   //°--°    Et avez pris la fouite tel un lache!!");
			System.out.println("      \\\\       Votre score final est : "+billy.getScore()+".");
			System.out.println("      (/       Votre dernier score était de : " + Save.load() + ".");
			
			Save.save(billy.getScore());
			outgame=true;
			
			
			break;
			
			}
			
			
			else if (saisieUtilisateur.charAt(0) == 's' || saisieUtilisateur.charAt(0) == 'z') {
				clear();
				
				if(!billy.getItems().getInventory().isEmpty()) {
					boolean value = false;
					int i =0;
					while(!value && i<billy.getItems().getInventory().size()) {
						if(billy.getItems().getInventory().get(i).equals(Powerup.PIOCHE)) {
							clear();
							i+=1;
							billy.getItems().removeItemsInInventory(Powerup.PIOCHE);
							bouger.moveVertically(map);
							billy.setScore(billy.getScore() + 1);
							bouger.difficulty(billy.getScore());
							value = true;
							
						}
						else {
							i+=1;
						}
					}
					
					if (!value) {
						System.out.println("Barbare que vous êtes, vous n'avez que des armes, vous pouvez toujours essayer de tirer à l'arc sur le mur...");
					}
				
				}
				
				else {
					System.out.println("Vous n'avez pas d'outils dans votre inventaire, bon courage pour casser le mur à la main.");
					bouger.detect(map, billy);
					bouger.moveMap(map);
					bouger.moveRight(map);
				}
			}
				
			else if (saisieUtilisateur.charAt(0) == 'i') {
				clear();
				System.out.println(billy.getItems().toStringInventory());
				System.out.println("vous avez " + billy.getBourse()+ " gemmes.");
			}
			else {
				clear();
				bouger.detect(map, billy);
				bouger.moveMap(map);
				bouger.moveRight(map);
			}
			if(billy.isDead()) {
				
				Save.loadText("./textes/Ecran_game_over");
								
				System.out.println("Votre score final est de : " + billy.getScore() + ".");
				System.out.println("Votre dernier score était de : " + Save.load() + ".");
				Save.save(billy.getScore());
				break;
			}
			System.out.println("Score: "+billy.getScore());
			for(int i = 0; i < billy.getLife(); i++) {
				System.out.print('❤');
			}
			System.out.println();
			
		}
			
	}
	
	public static void clear () {
		for (int i = 0; i<25; i++) {
			System.out.println("\n");
		}
	}
	
	public static void ecranTitre() {
		boolean continuer = false;
		while(!continuer) {
			
			Save.loadText("./textes/Ecran_titre");
			
			Scanner sc = new Scanner (System.in);
			String suite = sc.nextLine();
			continuer = true;
			clear();
		}
	}
}
