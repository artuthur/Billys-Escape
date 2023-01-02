package Billy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestBilly {

	private static final ArrayList<Powerup> listevide = new ArrayList <Powerup>();
//	public static MAP map = new MAP();
	public static Inventory inventaire = new Inventory();
	public static Billy billy = new Billy(3,inventaire,0,0);
	
	public static Monster monstre = new Monster(true, 1) ;

	@Test
	public void testBilly() {
		
		assertEquals(billy.getBourse(), 0); 
		assertEquals (billy.getLife(), 3); 
		assertEquals(billy.getName(), 'B'); 
		assertEquals(billy.getScore(), 0);
		assertEquals(billy.getItems().getInventory(), listevide) ;
		
		billy.setBourse(15);
		assertEquals(billy.getBourse(),15);
		
		billy.setLife(1);
		assertEquals(billy.getLife(), 1) ;
		assertEquals(billy.isDead(), false);
		
		billy.setScore(200);
		assertEquals(billy.getScore(),200);
		
		assertEquals(billy.toString(), "Billy a 1 vies.");
		
//		billy.setItems(Powerup.ARC);
		
		billy.looseOneLife(); 
		assertEquals(billy.isDead(), true); 
		
		billy.winOneLife(); 
		assertEquals(billy.getLife(),1);
		
		billy.winScore(); 
		assertEquals(billy.getScore(),201);
		
		billy.winBourse(); 
		assertTrue(billy.getBourse()>15 || billy.getBourse()<26);
		
	}
	
	@Test
	public void testInventory() {
		
		inventaire.addItemsInInventory(Powerup.ARC);
		assertEquals(inventaire.toStringInventory(), "Dans l'inventaire il y a 1 Arcs, 0 Pioches.");
		
		inventaire.addItemsInInventory(Powerup.PIOCHE);
		assertEquals(inventaire.toStringInventory(), "Dans l'inventaire il y a 1 Arcs, 1 Pioches.");

		
		inventaire.removeItemsInInventory(Powerup.ARC);
		inventaire.removeItemsInInventory(Powerup.PIOCHE);
		assertEquals(inventaire.toStringInventory(), "Dans l'inventaire il y a 0 Arcs, 0 Pioches.");
		
	}
	
	@Test
	public void testMontre() {
		
		Monster monstre = new Monster(true, 1) ;
		
		assertEquals(monstre.getStrength(), 1);
		assertEquals(monstre.getName(), 'M');
		assertTrue(monstre.isAlive()); 
		
		monstre.setAlive(false);
		
		assertFalse(monstre.isAlive());
		
		monstre.setStrength(2);
		assertEquals(monstre.getStrength(),2);
		
		monstre.setName('O');
		assertEquals(monstre.getName(),'O');
		
	}
	
	@Test
	public void testBoss() {
		
		Boss boss = new Boss (true, 2) ;
		assertEquals(boss.getStrength(), 2);
		
	}

}
