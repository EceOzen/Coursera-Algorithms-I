import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
    	
    	// Ensure there is exactly one command-line argument
        if (args.length != 2) {
            System.err.println("Use args correctly");
            return;
        }
	
    	RandomizedQueue<String> q = new RandomizedQueue<String>();
	
    	int k = Integer.valueOf(args[0]);
	
    	while (!StdIn.isEmpty()){
    		String item = StdIn.readString();
    		q.enqueue(item);
    	}
	
    	while (k > 0){
    		StdOut.println(q.dequeue());
    		k--;
    	}
    }
}