
public class Testing {
	public static void main(String[] args) {
		Message m = new Message ("encoded.txt");
		
		String output = m.compose();
		System.out.println(output);
	}
}
