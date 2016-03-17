import java.util.ArrayList;


public class Node {
	
		int type;
		ArrayList<Node> children = new ArrayList<Node>();
		String name;
		Node parent;
		String parentName;
		int [][] conf;
		int alpha;
		int beta;
		int value;
		ArrayList<String> invalid = new ArrayList<String>();
}
