package Billy;

public class Monster {
	private char name = 'M';
	private boolean alive;
	private int strength;
	
	public Monster(/*char name,*/ boolean alive, int strength) {
		/*this.name = name;*/
		this.alive = alive;
		this.strength = strength;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	
}
