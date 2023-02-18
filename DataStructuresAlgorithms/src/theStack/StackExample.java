package theStack;

//import Stack functionality
import java.util.Stack;

//Stack is LIFO (Last in, first out Data-structure 
//Like a stack of pancakes, or in this case, video games
public class StackExample {

	public static void main(String[] args) {
		//Can replace String with any object
		Stack<String> faveGames = new Stack<String>();
		
		/*
		 * Five unique methods for Stack
		 * push(object) == add object top of stack
		 * pop() == delete object at top of stack
		 * peak() == check object  at top of stack
		 * empty() == check to see if stack is empty
		 * search(object) == tells numeric position of object in the stack, top is 1, NOT ZERO
		 */
		
		System.out.println(faveGames.empty()); //true since we didn't add anything
		
		faveGames.push("Pikmin");
		faveGames.push("The Legend of Zelda, Wind Waker");
		faveGames.push("Doom Eternal");
		faveGames.push("Halo 3");
		faveGames.push("Persona 4");
		
		System.out.println(faveGames); //toString() will just show it as an array
		
		System.out.println(faveGames.search("Persona 4")); //1 == top of stack
		System.out.println(faveGames.search("Pikmin")); //5 == bottom of stack
		System.out.println(faveGames.search("Fortnite")); // -1 == not in stack
		
		
		System.out.println(faveGames.peek());
		
		faveGames.pop(); //Will pop off Persona4
		System.out.println(faveGames);
		String allTimeFavoriteGame = faveGames.pop(); //pop returns that value, so you can save them into variables
		System.out.println("My ALL TIME FAVORITE GAME IS " + allTimeFavoriteGame);
		
		
		faveGames.push("Super Mario World");
		System.out.println(faveGames);



	}

}
