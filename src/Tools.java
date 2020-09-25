import java.util.Scanner;

public class Tools {
	
	public static void enterToContinue(){
		Scanner enter = new Scanner(System.in);
		enter.nextLine();
	}
	
	public static void cls() {
		for(int i = 0;i<30;i++) {
			System.out.println("\n\n\n");
		}
	}
	
}
