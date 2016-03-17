import java.util.ArrayList;


public class TempNode2 {
	static int count;
	
	public TempNode2(){
		count++;count++;		
	}
	
	int i,j;
	int [][] board;
	int value;
	boolean leaf;
	int alp=-99999;
	int beta = 99999;
	ArrayList<TempNode2> chi = new ArrayList<TempNode2>();
}
