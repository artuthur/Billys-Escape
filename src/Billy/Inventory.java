package Billy;

import java.util.ArrayList;

public class Inventory {
	private ArrayList <Powerup> inventory = new ArrayList<Powerup>();
	private boolean inventoryFull;
	
	public boolean isInventoryFull() {
		return inventoryFull;
	}

	public void setInventoryFull(boolean inventoryFull) {
		this.inventoryFull = inventoryFull;
	}

	public ArrayList<Powerup> getInventory() {
		return inventory;
	}

	//Inventaire plein ou non.
	public boolean isFull() {
		if(!this.inventory.isEmpty()) {
			return this.inventoryFull = true;
		}else {
			return this.inventoryFull = false;
		}
	}
	
	public Inventory() {
		this.inventory = new ArrayList<Powerup>();
		this.inventoryFull = false;
	}
	
	//Affichage du contenu de l'inventaire
	public String toStringInventory() {
		int nbrArc=0;
		int nbrPioche=0;
		for(int i=0;i<inventory.size();i++) {
			if(inventory.get(i).equals(Powerup.ARC)) {
				nbrArc= nbrArc + 1;
			}if(inventory.get(i).equals(Powerup.PIOCHE)) {
				nbrPioche= nbrPioche + 1;
			}
		}
		return "Dans l'inventaire il y a "+ nbrArc +" Arcs, "+ nbrPioche + " Pioches.";
	}
	
	public void addItemsInInventory(Powerup pw) {
		if(!this.inventoryFull) {
			this.inventory.add(pw);			
		}
	}
	
	public void removeItemsInInventory(Powerup pw) {
		if(this.inventory.size()!=0) {
			this.inventory.remove(pw);			
		}
	}
	
}

