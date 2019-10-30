import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Packet implements Comparable<Packet>{
	private String portion;

	public Packet (String message) {
		portion = message;
	}

	public int getNumber() {
		String number = "";
		try {
			Scanner read = new Scanner(new File("encoded.txt"));
			
			while(read.hasNext()) {
				portion = read.nextLine();
				number = portion.replaceAll("[^0-20]", "");
			}
			read.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(number);
	}

	public String getText() {
		String result = "";
		
		try{
			Scanner read = new Scanner(new File("encoded.txt"));
			
			while(read.hasNext()) {
				portion = read.nextLine();
				result = portion.replaceAll("", portion);
			}
			read.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int compareTo(Packet p) {
		return this.getNumber() - p.getNumber();
	}
}
