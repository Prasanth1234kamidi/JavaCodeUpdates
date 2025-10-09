package Example;
import java.util.SequencedCollection;
import java.util.LinkedList;

public class SequencedCollectionPro 
{
	    public static void main(String[] args) {

	        // Create a SequencedCollection using LinkedList
	        SequencedCollection<String> tasks = new LinkedList<>();

	        // Add elements at the end
	        tasks.add("Task1");
	        tasks.add("Task2");
	        tasks.add("Task3");

	        System.out.println("Initial Collection: " + tasks);
	        // Output: [Task1, Task2, Task3]

	        // Add element at the first position
	        tasks.addFirst("UrgentTask");
	        System.out.println("After addFirst: " + tasks);
	        // Output: [UrgentTask, Task1, Task2, Task3]

	        // Remove the last element
	        tasks.removeLast();
	        System.out.println("After removeLast: " + tasks);
	        // Output: [UrgentTask, Task1, Task2]

	        // Remove the first element
	        tasks.removeFirst();
	        System.out.println("After removeFirst: " + tasks);
	        // Output: [Task1, Task2]

	        // Iterate over the sequenced collection
	        System.out.println("Iterating over tasks:");
	        for (String task : tasks) {
	            System.out.println(task);
	        }
	    }
	}

