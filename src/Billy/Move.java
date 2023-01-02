package Billy;
import java.util.*;

public class Move {
	int monsterSpawnRate = 10;
	int gemSpawnRate = 15;
	int powerupSpawnRate = 10;
	int shopkeeperSpawnRate = 4;
	int fairySpawnRate = 0;
	int bossSpawnRate = 5;
	
	Scanner sc = new Scanner (System.in);
	
	MAP moveMap (MAP map) {
		//mur du haut
		Random random = new Random();
		int value = random.nextInt(100);
		if(value < 30) {
			map.map.get(0).remove(0);
			map.map.get(0).add("-");
		} else {
			map.map.get(0).remove(0);
			map.map.get(0).add(".");
		}
		
		//mur du bas
		
		value = random.nextInt(100);
		if(value < 30) {
			map.map.get(2).remove(0);
			map.map.get(2).add("-");
		} else {
			map.map.get(2).remove(0);
			map.map.get(2).add(".");
		}
		return map;
	}
	MAP moveRight (MAP map) {
		 //récupère la première valeur 
		 String chaine = map.map.get(1).remove(0);
		 //change le nouveau caractère par la valeur sauvegarder
		 if(!map.map.get(1).isEmpty()) {
			 map.map.get(1).set(0, chaine);
		 } else {
			 map.map.get(1).add(chaine);
		 }
		 
		 //ajout d'un caractère aléatoire à la fin de la liste
		 Random random = new Random();
		 
		 int value = random.nextInt(100);
		 //spawn monstre
		 if(value > 100 - monsterSpawnRate) {
			 map.map.get(1).add("☠");
		//spawn gem
		 } else if (value > 100 - monsterSpawnRate - gemSpawnRate) {
			 map.map.get(1).add("♦");
		//spawn power up
		 } else if (value > 100 - monsterSpawnRate - gemSpawnRate - powerupSpawnRate) {
			 map.map.get(1).add("★");
		//spawn boutique
		 } else if (value > 100 - monsterSpawnRate - gemSpawnRate - powerupSpawnRate - shopkeeperSpawnRate) {
			 map.map.get(1).add("☖");
		//spawn fée
		 } else if(value > 100 - monsterSpawnRate - gemSpawnRate - powerupSpawnRate - shopkeeperSpawnRate - fairySpawnRate){
			 map.map.get(1).add("♥");
	     //spawn caractère vide
		 } else {
			 map.map.get(1).add(" ");
		 }
		
		 return map;
	 }
	
	void detect (MAP map, Billy billy) {
		//Monstre
		if(map.map.get(1).get(1).charAt(0) == '☠') {
			Monster monster;
			Random rand = new Random();
			int nombre = rand.nextInt(100);
			if (nombre > 100 - bossSpawnRate) {
				monster = new Boss(true, 2);
			} else {
				monster = new Monster(true, 1);
			}
			
			if(!billy.getItems().getInventory().isEmpty()) {
				if(monster.getStrength() > 1) {
					System.out.println("Mein gott!!!! Vous avez trouvé un ennemi SUPERieur à ceux que vous avez pu croiser auparavant !!!!  ლ(｀ー´ლ) ");
				}
				int i = 0;
				boolean foundItem = false;
				while(i < billy.getItems().getInventory().size() && foundItem != true) {
					if(billy.getItems().getInventory().get(i).equals(Powerup.ARC)) {
						System.out.println("Vous avez tué le monstre avec un arc, par manque de flèches vous lui avez lancé dessus.");
						billy.getItems().removeItemsInInventory(Powerup.ARC);
						monster.setAlive(false);
						foundItem = true;
					}
					i ++;
				}
				if(!foundItem) {
					if (billy.getLife() - monster.getStrength() < 0) {
						billy.setLife(0);
					} else if(billy.getLife() != 1) {
						
						billy.setLife(billy.getLife() - monster.getStrength());
						System.out.println("Vous avez perdu " + monster.getStrength() + " vie(s). Il vous reste "+billy.getLife()+" vie(s). Courage Billy!!");
					} else {
						billy.setLife(billy.getLife() - monster.getStrength());
					}
				}
			} else {
				if(monster.getStrength() > 1) {
					System.out.println("Mein gott!!!! Vous avez trouvé un ennemi SUPERieur à ceux que vous avez pu croiser auparavant !!!!  ლ(｀ー´ლ) ");
				}
				if(billy.getLife() != 1) {
					billy.looseOneLife();
					System.out.println("Vous avez perdu une vie. Il vous reste "+billy.getLife()+" vie(s). Courage Billy!!");
				} else {
					billy.setLife(billy.getLife() - monster.getStrength());
				}
			}
			
	
		} else if (map.map.get(1).get(1).charAt(0) == '♦') {
			int gem = billy.winBourse();
			System.out.println("Vous avez ramassé " + gem + " gemme(s) !");
			billy.setBourse(billy.getBourse() + gem);
		
		} else if (map.map.get(1).get(1).charAt(0) == '★') {
			Random random = new Random();
			int value = random.nextInt(2);
			if (value == 0) {
				billy.getItems().addItemsInInventory(Powerup.ARC);
				System.out.println("Vous avez gagné un arc !");
			} else if (value == 1) {
				billy.getItems().addItemsInInventory(Powerup.PIOCHE);
				System.out.println("Vous avez gagné une pioche");
			}
		}else if (map.map.get(1).get(1).charAt(0) == '☖') {
			System.out.println("Oh ! Un marchand est sur votre route. Voulez vous voir sa boutique ? \n 1. Oui \n 2. Non");
			
			String choixOption ="p";
			
			while (choixOption.charAt(0)!='1' && choixOption.charAt(0)!='2') {
				
				choixOption = sc.next();
				
				if (choixOption.charAt(0)=='1') {
					Main.clear();
					Shop.setShop();
					Shop.getItem(billy);
				} 
				
					
			}
			
			Main.clear();
		} else if(map.map.get(1).get(1).charAt(0) == '♥') {
			System.out.println("Une fée ! Vous gagnez une vie supplémentaire !");
			billy.setLife(billy.getLife()+1);
		}
	}
	 
	 MAP moveVertically (MAP map) {
		 
		 //MAP map = new MAP();
		 
		 map.Generation_Map();
		 
		 
		 for (int i =0; i<29; i+=1) {
			 Move move = new Move();
			 move.moveRight(map); 
			 
			 		 
		}
		map.map.get(1).set(1, " ");
		map.map.get(1).set(2, " ");
		map.map.get(1).set(3, " ");
		map.map.get(1).set(4, " ");
		map.map.get(1).set(5, " ");
		 return map;
	 	}
	 
	 
	 public void difficulty (int score) {
		 if(score >= 50 && (score % 50) == 0 && this.monsterSpawnRate <= 80)
		 this.monsterSpawnRate = this.monsterSpawnRate + 5;
	 }
	
	public static void main(String[] args) {
		
		Random random = new Random();
		int value = random.nextInt(2);
		System.out.println(value);
		
	}
}
