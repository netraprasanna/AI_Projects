
public class Main {
	public  static void main(String args[]) {
	MinMax obj  = new MinMax();
	
	long l1 = System.nanoTime();
	obj.start();
	int originalNodes = obj.valReturn();
	long l2 = System.nanoTime();
	
	long l3 = System.nanoTime();
	AlphaBeta obj1 = new AlphaBeta();
	obj1.init();
	int prunedNodes = TempNode2.count;
	long l4 = System.nanoTime();
	System.out.println("Comparison:");
	System.out.println("Minmax with pruning : running time " + ((l4-l3)/1000000.0) + "ms");
	//System.out.println("Minmax")
	System.out.println("Number of Pruned nodes = " + (originalNodes-prunedNodes));
	System.out.println("Minmax without pruning : running time " + ((l2-l1)/1000000.0) + "ms");
	
	}
}
