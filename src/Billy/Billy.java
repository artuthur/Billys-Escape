package Billy;

import java.util.Random;

public class Billy {
	private final char name = 'B' ;
	private int life = 3 ;
	private Inventory items ; 
	private int score = 0 ;
	private int bourse = 0 ;
	
	
	public Billy (int life, Inventory items, int score, int bourse) {
		this.life= life;
		this.items=items;
		this.score = score ;
		this.bourse = bourse ;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public Inventory getItems() {
		return items;
	}

	public void setItems(Inventory items) {
		this.items = items;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBourse() {
		return bourse;
	}

	public void setBourse(int bourse) {
		this.bourse = bourse;
	}

	public char getName() {
		return name;
	}

	public String toString() {
		return "Billy a " + this.life + " vies." ;
	}
	
	public int looseOneLife() {
		this.life = this.life-1 ; 
		return this.life;
	}
	
	public int winOneLife() {
		if (this.life < 4 ) {
			this.life = this.life+1 ; 
		} 
		return this.life ;
	}
	
	public boolean isDead() {
		if(this.life==0) {
			return true;
		}
		return false;
	}
	
	public int winScore (){
		this.score = this.score + 1 ;
		return this.score ;
	}
	
	public int winBourse () {
		Random rand = new Random();
		int nombre = rand.nextInt(10) +1;
		return nombre; 
	}
	
	
	
	

}
