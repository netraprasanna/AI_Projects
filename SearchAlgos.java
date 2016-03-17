import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class SearchAlgos {
	

	public static Node id1 = new Node("id1",12,1);
	public static Node id2 = new Node("id2",16,2);
	public static Node id3 = new Node("id3",20,3);
	public static Node id4 = new Node("id4",19,4);
	public static Node id5 = new Node("id5",18,5);
	public static Node id6 = new Node("id6",11,6);
	public static Node id7 = new Node("id7",17,7);
	public static Node id8 = new Node("id8",10,8);
	public static Node id9 = new Node("id9",20,9);
	public static Node id10 = new Node("id10",15,10);
	public static Node id11 = new Node("id11",17,11);
	public static Node id12 = new Node("id12",9,12);
	public static Node id13 = new Node("id13",14,13);
	public static Node id14 = new Node("id14",13,14);
	public static Node id15 = new Node("id15",19,15);
	public static Node id16 = new Node("id16",16,16);
	public static Node id17 = new Node("id17",15,17);
	public static Node id18 = new Node("id18",8,18);
	public static Node id19 = new Node("id19",7,19);
	public static Node id20 = new Node("id20",10,20);
	public static Node id21 = new Node("id21",7,21);
	public static Node id22 = new Node("id22",15,22);
	public static Node id23 = new Node("id23",17,23);
	public static Node id24 = new Node("id24",6,24);
	public static Node id25 = new Node("id25",8,25);
	public static Node id26 = new Node("id26",13,26);
	public static Node id27 = new Node("id27",7,27);
	public static Node id28 = new Node("id28",9,28);
	public static Node id29 = new Node("id29",9,29);
	public static Node id30 = new Node("id30",9,30);
	public static Node id31 = new Node("id31",12,31);
	public static Node id32 = new Node("id32",6,32);
	public static Node id33 = new Node("id33",13,33);
	public static Node id34 = new Node("id34",15,34);
	public static Node id35 = new Node("id35",14,35);
	public static Node id36 = new Node("id36",15,36);
	public static Node id37 = new Node("id37",12,37);
	public static Node id38 = new Node("id38",16,38);
	public static Node id39 = new Node("id39",9,39);
	public static Node id40 = new Node("id40",12,40);
	
	public static Node start = id2;
	public static Node end = id39;
	
	public static ArrayList<Node> input = new ArrayList<Node>();
	public static Queue<Node> q= new LinkedList<Node>();
	public static Stack<Node> s = new Stack<Node>();
	
 	public static Comparator<Node> compareobj;
	
 	public static ArrayList<Node> ucslist = new ArrayList<Node>();
	
	
	public static void populateData()
	{
	id1.neighbours.add(id2);
	id1.neighbours.add(id6);
	id1.index = "("+1+","+1+")";
	
	id2.neighbours.add(id3);
	id2.neighbours.add(id1);
	id2.neighbours.add(id7);
	id2.index = "("+2+","+1+")";
	
	id3.neighbours.add(id4);
	id3.neighbours.add(id2);
	id3.neighbours.add(id8);
	id3.index = "("+3+","+1+")";
	
	id4.neighbours.add(id5);
	id4.neighbours.add(id3);
	id4.neighbours.add(id9);
	id4.index = "("+4+","+1+")";
	
	id5.neighbours.add(id4);
	id5.neighbours.add(id10);
	id5.index = "("+5+","+1+")";
	
	id6.neighbours.add(id7);
	id6.neighbours.add(id1);
	id6.neighbours.add(id11);
	id6.index = "("+1+","+2+")";
	
	id7.neighbours.add(id8);
	id7.neighbours.add(id2);
	id7.neighbours.add(id6);
	id7.neighbours.add(id12);
	id7.index = "("+2+","+2+")";
	
	id8.neighbours.add(id9);
	id8.neighbours.add(id3);
	id8.neighbours.add(id7);
	id8.neighbours.add(id13);
	id8.index = "("+3+","+2+")";
	
	id9.neighbours.add(id10);
	id9.neighbours.add(id4);
	id9.neighbours.add(id8);
	id9.neighbours.add(id14);
	id9.index = "("+4+","+2+")";
	
	id10.neighbours.add(id5);
	id10.neighbours.add(id9);
	id10.neighbours.add(id15);
	id10.index = "("+5+","+2+")";
	
	id11.neighbours.add(id12);
	id11.neighbours.add(id6);
	id11.neighbours.add(id16);
	id11.index = "("+1+","+3+")";
	
	id12.neighbours.add(id13);
	id12.neighbours.add(id7);
	id12.neighbours.add(id11);
	id12.neighbours.add(id17);
	id12.index = "("+2+","+3+")";
	
	id13.neighbours.add(id14);
	id13.neighbours.add(id8);
	id13.neighbours.add(id12);
	id13.neighbours.add(id18);
	id13.index = "("+3+","+3+")";
	
	id14.neighbours.add(id15);
	id14.neighbours.add(id9);
	id14.neighbours.add(id13);
	id14.neighbours.add(id19);
	id14.index = "("+4+","+3+")";
	
	id15.neighbours.add(id10);
	id15.neighbours.add(id14);
	id15.neighbours.add(id20);
	id15.index = "("+5+","+3+")";
	
	id16.neighbours.add(id17);
	id16.neighbours.add(id11);
	id16.neighbours.add(id21);
	id16.index = "("+1+","+4+")";
	
	id17.neighbours.add(id18);
	id17.neighbours.add(id12);
	id17.neighbours.add(id16);
	id17.neighbours.add(id22);
	id17.index = "("+2+","+4+")";
	
	id18.neighbours.add(id19);
	id18.neighbours.add(id13);
	id18.neighbours.add(id17);
	id18.neighbours.add(id23);
	id18.index = "("+3+","+4+")";
	
	id19.neighbours.add(id20);
	id19.neighbours.add(id14);
	id19.neighbours.add(id18);
	id19.neighbours.add(id24);
	id19.index = "("+4+","+4+")";
	
	id20.neighbours.add(id15);
	id20.neighbours.add(id19);
	id20.neighbours.add(id25);
	id20.index = "("+5+","+4+")";
	
	id21.neighbours.add(id22);
	id21.neighbours.add(id16);
	id21.neighbours.add(id26);
	id21.index = "("+1+","+5+")";
	
	id22.neighbours.add(id23);
	id22.neighbours.add(id17);
	id22.neighbours.add(id21);
	id22.neighbours.add(id27);
	id22.index = "("+2+","+5+")";
	
	id23.neighbours.add(id24);
	id23.neighbours.add(id18);
	id23.neighbours.add(id22);
	id23.neighbours.add(id28);
	id23.index = "("+3+","+5+")";
	
	id24.neighbours.add(id25);
	id24.neighbours.add(id19);
	id24.neighbours.add(id23);
	id24.neighbours.add(id29);
	id24.index = "("+4+","+5+")";
	
	id25.neighbours.add(id20);
	id25.neighbours.add(id24);
	id25.neighbours.add(id30);
	id25.index = "("+5+","+5+")";
	
	id26.neighbours.add(id27);
	id26.neighbours.add(id21);
	id26.neighbours.add(id31);
	id26.index = "("+1+","+6+")";
	
	id27.neighbours.add(id28);
	id27.neighbours.add(id22);
	id27.neighbours.add(id26);
	id27.neighbours.add(id32);
	id27.index = "("+2+","+6+")";
	
	id28.neighbours.add(id29);
	id28.neighbours.add(id23);
	id28.neighbours.add(id27);
	id28.neighbours.add(id33);
	id28.index = "("+3+","+6+")";
	
	id29.neighbours.add(id30);
	id29.neighbours.add(id24);
	id29.neighbours.add(id28);
	id29.neighbours.add(id34);
	id29.index = "("+4+","+6+")";
	
	id30.neighbours.add(id25);
	id30.neighbours.add(id29);
	id30.neighbours.add(id35);
	id30.index = "("+5+","+6+")";
	
	id31.neighbours.add(id32);
	id31.neighbours.add(id26);
	id31.neighbours.add(id36);
	id31.index = "("+1+","+7+")";
	
	id32.neighbours.add(id33);
	id32.neighbours.add(id27);
	id32.neighbours.add(id31);
	id32.neighbours.add(id37);
	id32.index = "("+2+","+7+")";
	
	id33.neighbours.add(id34);
	id33.neighbours.add(id28);
	id33.neighbours.add(id32);
	id33.neighbours.add(id38);
	id33.index = "("+3+","+7+")";
	
	id34.neighbours.add(id35);
	id34.neighbours.add(id29);
	id34.neighbours.add(id33);
	id34.neighbours.add(id39);
	id34.index = "("+4+","+7+")";
	
	id35.neighbours.add(id30);
	id35.neighbours.add(id34);
	id35.neighbours.add(id40);
	id35.index = "("+5+","+7+")";
	
	id36.neighbours.add(id37);
	id36.neighbours.add(id31);
	id36.index = "("+1+","+8+")";
	
	id37.neighbours.add(id38);
	id37.neighbours.add(id32);
	id37.neighbours.add(id36);
	id37.index = "("+2+","+8+")";
	
	id38.neighbours.add(id39);
	id38.neighbours.add(id33);
	id38.neighbours.add(id37);
	id38.index = "("+3+","+8+")";
	
	id39.neighbours.add(id40);
	id39.neighbours.add(id34);
	id39.neighbours.add(id38);
	id39.index = "("+4+","+8+")";
	
	id40.neighbours.add(id35);
	id40.neighbours.add(id39);
	id40.index = "("+5+","+8+")";
		
}

public static void main(String args[])
{
	
	populateData();
	input.add(id1);
	input.add(id2);
	input.add(id3);
	input.add(id4);
	input.add(id5);
	input.add(id6);
	input.add(id7);
	input.add(id8);
	input.add(id9);
	input.add(id10);
	input.add(id11);
	input.add(id12);
	input.add(id13);
	input.add(id14);
	input.add(id15);
	input.add(id16);
	input.add(id17);
	input.add(id18);
	input.add(id19);
	input.add(id20);
	input.add(id21);
	input.add(id22);
	input.add(id23);
	input.add(id24);
	input.add(id25);
	input.add(id26);
	input.add(id27);
	input.add(id28);
	input.add(id29);
	input.add(id30);
	input.add(id31);
	input.add(id32);
	input.add(id33);
	input.add(id34);
	input.add(id35);
	input.add(id36);
	input.add(id37);
	input.add(id38);
	input.add(id39);
	input.add(id40);
	search();
}

public static void search(){
	while(true){
	 System.out.println();
	System.out.println("Enter the number for the required search algorithm");
	System.out.println("1: BFS");
	System.out.println("2: DFS");
	System.out.println("3: UCS");
	System.out.println("4: Exit");
	Scanner in = new Scanner(System.in);
	int num = in.nextInt();
	
	switch (num)
	{
	case 1: bfs();
	break;
	case 2: dfs();
	break;
	case 3: ucs();
	break;
	case 4: System.exit(1);
	}
	}
	}
public static void print(Node n)
{	
	if(n==end)
		System.out.print(n.index);
	else
		System.out.print(n.index+",");
}

public static void clear()
{
	for(int i=0;i<40;i++)
	{
		input.get(i).visited=false;
			
	}
}

public static void printStitch(int fin,ArrayList<Node> list)
{
	ArrayList<Node> disp = new ArrayList<Node>();
	disp.add(list.get(fin-1));
	while(fin!=2)
	{	
		int p = list.get(fin-1).par;
		disp.add(list.get(p-1));
		fin=p;
	}
	
	for(int z = disp.size()-1;z>=0;z--)
	{
		print(disp.get(z));
	}
	
}


public static void bfs()
{
	q.add(start);
	start.visited=true;
	
	System.out.println("BFS Traversal Order");
	while(!q.isEmpty()){
	Node node = (Node)q.remove();
	
	if(node==end)
	{
		print(end);
		System.out.println();
		System.out.println("BFS Stitching Curve");
		printStitch(end.ind,input);
		clear();
		return;
	}
	else
	{
		print(node);
	for(Node adj: node.neighbours )
	{	
		
		if(adj.visited == false)
		{	
			adj.par = node.ind;
			adj.parent = node;
			adj.visited = true;
			q.add(adj);
		}
	}//for
	}	//else
	}//while
	clear();
}

public static void dfs()
{	
	s.push(start);
	start.visited=true;
	//print(start);
	System.out.println();
	System.out.println("DFS traversal Order");
	print(start);
	while(!s.isEmpty()){
	Node node1 = (Node)s.peek();
	
	if(node1==end)
	{
		System.out.println();
		System.out.println("DFS Stitching Curve");
		printStitch(end.ind,input);
		clear();
		return;
	}
	Node proc = getprocnode(node1);
	if(proc !=null)
	{	
				proc.visited = true;
				print(proc);
				s.push(proc);
	}	
	else
	{
				s.pop();
	}
		
	
	}//while
	clear();
}
public static Node getprocnode(Node node1)
{ 
	for(Node adj1: node1.neighbours )
	{	
			if(adj1.visited == false)
			{	
				adj1.par = node1.ind;
				adj1.parent = node1;
				return adj1;
			}
	}
	return null;	
}


public static void ucs()
{
	procneighbours();
	start.min = 0;
	ucslist.add(start);
	
	System.out.println("UCS Traversal Order");
	while(!ucslist.isEmpty())
	{
		Node out = ucslist.remove(0);
		print(out);
		
		if(end == out)
		break;
		
		for(Node adj: out.neighbours)
		{
			Integer adjwt = adj.cost;
			Integer dis = out.min + adjwt;
			if(dis < adj.min)
			{	
				if(ucslist.contains(adj))
				ucslist.remove(ucslist.indexOf(adj));
				adj.min = dis;
				adj.par = out.ind;
				adj.parent = out;
				ucslist.add(adj);
				sort(ucslist);
			}
			
		}
	}
	System.out.println();
	System.out.println("UCS Stitching Curve");
	printStitch(end.ind,input);
}
public static void sort(ArrayList<Node> a)
{
	for(int i=1;i<a.size();i++){
		for(int j=0;j<a.size()-i;j++)
		{
			if (a.get(j).min > a.get(j+1).min)
			{
				Node n1 = a.get(j);
				Node n2 = a.get(j+1);
				
				a.set(j,n2);
				a.set(j+1,n1);
								
			}
		}
	}
	
}

public static void procneighbours()
{
	SearchAlgos sa = new SearchAlgos();
	compareobj = sa.new PathCostComparator();
	
	for(int i=0;i<input.size();i++)
	{
		input.get(i).min = 99999;
		Collections.sort(input.get(i).neighbours,compareobj);
		
	}
}
private class PathCostComparator implements Comparator<Node> {

    public int compare(Node node1, Node node2) {
        return node1.cost.compareTo(node2.cost);
    }
}
}
class Node
{
	Integer cost;
	int ind,par;
	
	Node parent;
	int min;
	boolean visited=false;
    String id,index;
    ArrayList<Node> neighbours = new ArrayList<Node>();
   
    Node(String id,int c,int i)
    {
    	this.id=id;
    	this.cost=c;
    	this.ind = i;
    }
}

	
