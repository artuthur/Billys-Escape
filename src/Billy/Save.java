package Billy;



import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;

import java.util.List;

public class Save {
	public static void save(int score) {
		try(FileWriter file = new FileWriter("./csv/save.csv")) {
			file.write("" + score);
			file.flush();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int load() {
		File file = new File("./csv/save.csv");
		try {
			String content = Files.readString(file.toPath());
			int score = Integer.parseInt(content);
			return score;
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
		}catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static List<String> loadText(String path) {
		File file = new File(path);
		try {
			String content = Files.readString(file.toPath());
			System.out.println(content);
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public static void main(String[] args) {
		save(12);
		int result = load();
		System.out.println(result);
		
		Save.loadText("./csv/test");
	}
}
