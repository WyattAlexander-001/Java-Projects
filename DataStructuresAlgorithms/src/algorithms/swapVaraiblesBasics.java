package algorithms;

public class swapVaraiblesBasics {

	public static void main(String[] args) {
		String x = "Water";
		String y = "Kool-Aid";
		String temp;
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		System.out.println("\n============\n");
		//Swap:
		//x=y or y=x won't work. 
		//It just makes them equal the other
		
		temp = x; // contents of x are now in temp
		x=y;
		y=temp;
		
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		
	}
}
