import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Message {
	private SortedLinkedList <Packet> messageList;

	public Message (String fileName) {
		try {
			Scanner read = new Scanner(new File(fileName));

			while(read.hasNext()) {
				messageList.addEntry(new Packet (read.nextLine()));
			}

			// closing the Scanner class
			read.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found! " + e);
		}
	}

	public String compose () {
		String out = "";

		Packet[] packets = (Packet[]) messageList.toArray();

		for (Packet p: packets)
			out += p.getText();
		return out;
	}
}
