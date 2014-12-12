import java.util.Scanner;

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		TextDisplay td = new TextDisplay();
		Thread t = new Thread (td);
		char userInput = 0;
		t.start();
		while (userInput != 'x'){
			try {
				userInput = (char)System.in.read();
				td.moveSnake(userInput);
				td.printDisplay();
			} catch (Exception e){
				
			}
		}
	}
}