package Billy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Shop {
	public static ArrayList<String> rayon = new ArrayList<String>();
	public Random rand = new Random() ;
	
	public static void getItem(Billy billy) {
		
		Save.loadText("./textes/Ecran_shop");
		
		System.out.println("Bonjour mon jeune ami ! Bienvenu dans mon humble Shop, AKA demeure, AKA boutique personelle et professionnelle ! ԅ(≖‿≖ԅ) \nTu possèdes " + billy.getBourse() + " gemmes.\nQue veux-tu acheter?\n");
		
		Scanner sc = new Scanner (System.in);
		
		String choixItem;
		boolean choix = false ; 
		
		while(!choix) {
			
			
			Shop.displayShop();
			choixItem = sc.next();
			
			
			
		
			if (choixItem.charAt(0)=='1') {
				if (billy.getBourse()>=35) {
					billy.setBourse(billy.getBourse()-35);
					billy.setLife(billy.getLife()+1);
					Main.clear();
					Save.loadText("./textes/Ecran_shop");
					System.out.println("Merci bien jeune voyageur talentueux du nom de Billy! (Billy le bougre devrai-je direeeee...) \n");
				} else {
					Main.clear();
					Save.loadText("./textes/Ecran_shop");
					System.out.println("La fée c'est une Queen, elle vaut plus cher que ça en fait, brow !! (ง'̀-'́)ง  \n");
				}
			} else if (choixItem.charAt(0)=='2') {
				if (billy.getBourse()>=25) {
					billy.getItems().addItemsInInventory(Powerup.ARC);
					billy.setBourse(billy.getBourse()-25);
					Main.clear();
					Save.loadText("./textes/Ecran_shop");
					System.out.println("Merci bien jeune voyageur talentueux du nom de Billy! (Billy le bougre devrai-je direeeee...) \n");
				}else {
					Main.clear();
					Save.loadText("./textes/Ecran_shop");
					System.out.println("Hé brow t'as pas de thune là, te fou pas d'moi !! (Ծ‸ Ծ) \n");
				}
			} else if (choixItem.charAt(0)=='3') {
				if (billy.getBourse()>=25) {
					billy.getItems().addItemsInInventory(Powerup.PIOCHE);
					billy.setBourse(billy.getBourse()-25);
					Main.clear();
					Save.loadText("./textes/Ecran_shop");
					System.out.println("Merci bien jeune voyageur talentueux du nom de Billy! (Billy le bougre devrai-je direeeee...) \n");
				}else {
					Main.clear();
					Save.loadText("./textes/Ecran_shop");
					System.out.println("T'es complètement marteau !! Cet engin vaut bien plus cher que ça, brow. (Ծ‸ Ծ) \n");
				}
			}else if(choixItem.charAt(0)=='4') {
				if (billy.getBourse()>=66) {
					billy.setLife(billy.getLife()+3);
					billy.setBourse(billy.getBourse()-66);
					Main.clear();
					Save.loadText("./textes/Ecran_shop");
					System.out.println("Merci bien jeune voyageur talentueux du nom de Billy! (Billy le bougre devrai-je direeeee...) \n");
				}else {
					Main.clear();
					Save.loadText("./textes/Ecran_shop");
					System.out.println("T'es complètement marteau !! Cet engin vaut bien plus cher que ça, brow. (Ծ‸ Ծ) \n");
				}
			}else if (choixItem.charAt(0)=='5') {
				Save.loadText("./textes/Ecran_shop");
				System.out.println("Merci d'et' passé, BROW !! (☞ﾟヮﾟ)☞  \n");
				choix = true;
			}
		
		}
		
		Shop.clear();
		
	}
	
	public static void clear () {
		for (int i = 0; i<25; i++) {
			System.out.println("\n");
		}
	}
	
	public static void setShop() {
		if (rayon.isEmpty()) {
			rayon.add("Fée, 35 gems.");
			rayon.add("Arc, 25 gems.");
			rayon.add("Pioche, 25 gems.");
			rayon.add("Armure, 66 gems.");
		}
	}
	
	public static void displayShop() {
		String res = "" ; 
		for (int i = 0; i<rayon.size() ; i++) {
			res = res + (i+1) + ". "  + rayon.get(i)+ ", \n";
		}
		//Save.loadText("./textes/Ecran_shop");
		System.out.println(res);
		System.out.println("5. Quitter le shop");
		
		
		
	}
	
//	public static void main(String[] args) {
//		Shop shop = new Shop();
//		Inventory inventaire = new Inventory();
//		Billy billy = new Billy(3,inventaire,0,0);
//		
//		shop.setShop();
//		shop.getItem(billy);
//		
//	}

}
