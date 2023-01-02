package Billy;

public class Display {
	private MAP map;
	
	public Display(MAP map) {
		this.map = map;
	}

	public MAP getMap() {
		return map;
	}

	public void setMap(MAP map) {
		this.map = map;
	}

	@Override
	public String toString() {
		String s = "";
		map.Generation_Map();
		
		String l0 = "";
		for(int i = 0; i < map.map.get(0).size(); i++) {
			l0 += map.map.get(0).get(i);
		}
		
		String l1 = "";
		for(int i = 0; i < map.map.get(1).size(); i++) {
			l1 += map.map.get(1).get(i);
		}
		
		String l2 = "";
		for(int i = 0; i < map.map.get(2).size(); i++) {
			l2 += map.map.get(2).get(i);
		}
		
		s = l0+"\n"+l1+"\n"+l2+"\n";
		return s;
	}
	
	
	
}
