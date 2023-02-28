package theQueue;
import java.util.*;
public class thePriorityQueue {

	//Priority Queue == FIFO data struct based on highest priority first
	public static void main(String[] args) {
		Queue<Double> gpa = new PriorityQueue<>(Collections.reverseOrder());
		
		gpa.offer(3.0);
		gpa.offer(2.5);
		gpa.offer(4.0);
		gpa.offer(1.5);
		gpa.offer(2.0);
		
		//Displays elements in ascending order by default, 
		//Pass Collections.reverseOrder() into constructor
		while(!gpa.isEmpty()) {
			System.out.println(gpa.poll());
		}
		
		
		Queue<String> letterGrade = new PriorityQueue<>();
		letterGrade.offer("B");
		letterGrade.offer("A+");
		letterGrade.offer("C");
		letterGrade.offer("D+");
		letterGrade.offer("A-");
		letterGrade.offer("A");
		letterGrade.offer("F");
		letterGrade.offer("D-");
		letterGrade.offer("B-");
		//Perhaps + is unneeded 
		while(!letterGrade.isEmpty()) {
			System.out.println(letterGrade.poll());
		}
	}
}
