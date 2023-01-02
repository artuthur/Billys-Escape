package Billy;

import java.util.ArrayList;
import java.util.Random;

public class MAP {
    //Longueur de la map : 30 char
    ArrayList <ArrayList <String>> map = new ArrayList <ArrayList <String>>();
    
    

public ArrayList <String> Generation_Mur(){
	ArrayList <String> mur = new ArrayList <String>();
	
	Random random = new Random();
	int value;
	
	for (int i =0; i<158; i+=1) {
		value = random.nextInt(100);
		
		if (value>30) {
			mur.add("-");
		}
		
		else {
		mur.add(".");
		}
	}
	return mur;
}
    
    
public ArrayList <ArrayList <String>> Generation_Map(){
    
	ArrayList <String> Billy = new ArrayList <String>();
	Billy.add("B");
	
	for (int i =0; i<157; i+=1) {
		Billy.add(" ");
	}
	
	this.map.add(Generation_Mur());
	this.map.add(Billy);
	this.map.add(Generation_Mur());
	
	return this.map;
}


}

