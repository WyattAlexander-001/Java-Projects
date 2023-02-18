package theArray;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		String[][] cars = new String[3][3]; //3 arrays, 3 elements (row,column)
		
		cars[0][0] = "Camaro";
		cars[0][1] = "Corvetter";
		cars[0][1] = "Silverado";
		
		cars[1][0] = "Mustang";
		cars[1][1] = "Corvetter";
		cars[1][2] = "Silverado";				
		
		cars[2][0] = "Jeep";
		cars[2][1] = "Mitzubishi";
		cars[2][2] = "Ford";		
		
		System.out.println(cars); // Will only print out memory address using the toString method of String class
		System.out.println(cars.length); //will give back only rows it's a 3x3 so it will be 3, but if it was 22x3, it would print 22
		
		for(int i= 0; i < cars.length; i++) {
			System.out.println("------------"); // Buffer
			for(int j =0; j<cars[i].length; j++) {
				System.out.println(cars[i][j] + " ");
			}
		}
		
		System.out.println("------------");
		//Shorthand to make a 2D array
		String[][] food = {
				{"Apple", "Mango", "Kiwi"},
				{"Chicken", "Beef", "Pork"},
				{"Rice", "Bread", "Pasta"},
		};
		
		System.out.println(food[1][1]);
		
		

	}

}
