package theQueue;

//Imports needed:
import java.util.Queue;
import java.util.LinkedList;

//Queue are FIFO datastruct, like a deli line
//Head is the start, tail is end. If line is 1 unit it's head/tail

//En-queue => add to the tail
//De-queue +> remove from head

//Useful for keyboard buffers
//Printer queues
//BFS Algo
public class QueueExample {
	public static void main(String[] args) {
		//Queues are an interface, not a class, cannot instantiate them
		//Must use LinkedList or PriorityQueue
		//Queue has: 
		//offer()==add to tail 
		//poll()==remove head 
		//peek() == examine head
		Queue<String> deli = new LinkedList<String>();
		
		deli.offer("Luffy");
		deli.offer("Sanji");
		deli.offer("Usopp");
		deli.offer("Nami");
		
		System.out.println(deli);
		System.out.println(deli.peek());
		
		String luffy = deli.poll();
		System.out.println(luffy + " ate a giant steak and left.");
		System.out.println(deli);
		
		
		//Queue inherit from the Collections class
		System.out.println("Is the deli line empty?");
		System.out.println(deli.isEmpty());
		
		System.out.println("What is the size of the deli line?");
		System.out.println(deli.size());
		
		System.out.println("Is Nami in the deli line?");
		System.out.println(deli.contains("Nami")); //case sensitive
		
		
		
	}

}
