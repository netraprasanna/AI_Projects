import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class MV {
	int index,par;
	MV parent;
	String name;
	Integer heuristics;
	boolean visted = false;
	int mindistance;
	int path;
	boolean expanded=false;
	ArrayList<MV> adj = new ArrayList<MV>();
	
	
	MV(int index,int heuristics,String name){
		this.heuristics=heuristics;
		this.index=index;
		this.name=name;
	}
	
}
public class Greedy {
	public static ArrayList<MV> mvs = new ArrayList<MV>();
	public static ArrayList<MV> amvs = new ArrayList<MV>();
	public static Comparator<MV> compareobj;
	static ArrayList<MV> queue1 = new ArrayList<MV>();
	static ArrayList<MV> olist=new ArrayList<MV>();
	static Queue<MV> clist = new LinkedList<MV>();
	static MV cur;
	int a[][]=
	{
			{0,1,0,1,0,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,1,0,0,0,0},
			{0,0,0,0,1,0,0,0,1,0,0,0,0},
			{0,0,0,1,0,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,0,0,1,0,0,0},
			{0,0,0,0,1,0,0,1,0,0,0,0,0},
			{0,1,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,1,1,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,1,0,0,0,0,0,0},
			{0,0,0,0,0,1,0,0,0,1,0,0,0},
			{0,0,0,0,1,0,0,1,0,0,0,0,0},
			{0,1,0,1,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0}			
		
	
	};
	
	int m[][]={
			{0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,1,1,0,1,0,0,0,0},
			{0,1,0,0,0,1,1,1,0,0,0,0,0},
			{0,1,0,0,0,1,0,1,1,0,0,0,0},
			{0,0,1,1,1,0,0,0,0,1,0,0,0},
			{0,0,1,1,0,0,0,0,0,1,1,0,0},
			{0,0,0,1,1,0,0,0,0,1,0,1,0},
			{0,0,1,0,1,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,1,1,1,0,0,0,0,1},
			{0,0,0,0,0,0,1,0,1,0,0,0,1},
			{0,0,0,0,0,0,0,1,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,1,1,1,0}
			
	}; 
	
	static int v[][]={
			{0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,2,4,1,0,0,0,0,0,0,0,0},
			{0,2,0,0,0,1,1,0,2,0,0,0,0},
			{0,3,0,0,0,1,1,1,0,0,0,0,0},
			{0,1,0,0,0,2,0,2,1,0,0,0,0},
			{0,0,1,1,2,0,0,0,0,1,0,0,0},
			{0,0,1,1,0,0,0,0,0,1,1,0,0},
			{0,0,0,1,2,0,0,0,0,1,0,1,0},
			{0,0,2,0,1,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,1,1,1,0,0,0,0,1},
			{0,0,0,0,0,0,1,0,1,0,0,0,1},
			{0,0,0,0,0,0,0,1,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,1,1,1,0}
			
	};
	
	public static int cusd[][]={
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0}

		};
	public static void initialize(ArrayList<MV> mvs) {
		Greedy g = new Greedy();
		compareobj = g.new HeuComparator();
		for(int i=0;i<mvs.size();i++){
			//Node temp=nodes.get(i);
			//mvs.get(i).mindistance=99999;
			Collections.sort(mvs.get(i).adj,compareobj);

		}
			
		}
	public static void cd(){
		for(int k=0;k<1;k++){
			for(int l=0;l<1;l++){
				cusd[k][l]=0;
			}
		}
		int a,b;
		for(int k=1;k<=12;k++){
			for(int l=1;l<=12;l++){
				if(v[k][l]!=0){
				a=(k+l)%5 +1;
				b=5-v[k][l];
				cusd[k][l]=a*b;
				}
			}
		}
	}
	
	public static int cd(int i,int j){
		if(i==j)return 0;
		int a,b;
		a=(i+j)%5 +1;
		b=5-v[i][j];
		return a*b;
	}
	
	
	public static void as(){
		Comparator<MV> cObject=new Comparator<MV>() {
			public int compare(MV m1,MV m2){
				if(m1.heuristics + m1.path < m2.heuristics + m2.path )return -1;
				if(m1.heuristics + m1.path > m2.heuristics + m2.path )return 1;
				if(m1.heuristics + m1.path == m2.heuristics + m2.path ){
					if(m1.index<m2.index)return -1;
					else return 1;
				}
				return 0;
			}
		};
		
		MV start = amvs.get(0);
	    MV current = start;
		MV out = current;
		olist.add(start);
		start.visted=true;
		System.out.println();
		System.out.println();
		System.out.println("A * traversal sequence ");
		printNode(start);
		start.path=0;
		start.parent=start;
		while(amvs.get(11).expanded==false && !olist.isEmpty()){
			out = olist.remove(0);
			out.expanded=true;
			clist.add(out);
			if(out==amvs.get(11)){
				printstichingcurve(12,amvs);
				break;
			}
			for(int i=0;i<out.adj.size();i++){
				if(out.adj.get(i).expanded==false && out.adj.get(i).visted==false){
					out.adj.get(i).parent=out;
					out.adj.get(i).par=out.index;
					out.adj.get(i).path=out.path+cd(out.index,out.adj.get(i).index);
					out.adj.get(i).visted=true;
					if(!olist.contains(out.adj.get(i))){
						olist.add(out.adj.get(i));
						
					}
				}else if(out.adj.get(i).expanded==false && out.adj.get(i).visted==true) {
					if(cd(out.adj.get(i).parent.index,out.adj.get(i).index) + out.adj.get(i).heuristics > (out.adj.get(i).heuristics + cd(out.parent.index,out.index) + cd(out.index,out.adj.get(i).index))){
						out.adj.get(i).parent=out;
						out.adj.get(i).par=out.index;
						out.adj.get(i).path=out.path+cd(out.index,out.adj.get(i).index);
						if(!olist.contains(out.adj.get(i))){
							olist.add(out.adj.get(i));
						}
					}
				}
			}
				Collections.sort(olist,cObject);
				current = olist.get(0);
				printNode(current);
			
		}
	}
			
			
	public static void clear()
    {
            for(int i=0;i<12;i++)
            {
                    mvs.get(i).visted=false;
                    mvs.get(i).expanded=false;
                    mvs.get(i).parent=null;
                    mvs.get(i).par=0;
                    
                            
            }
    }
	
	public class HeuComparator implements Comparator<MV> {

		public int compare(MV o1, MV o2) {
		return o1.heuristics.compareTo(o2.heuristics);
		}
		}
	
	public static void printstichingcurve(int f, ArrayList<MV> nodes){
				
		ArrayList<MV>toPrint = new ArrayList<MV>();
		toPrint.add(nodes.get(f-1));
		//System.out.print(nodes.get(f).gIndex + " ");
		while(f!=1){
			int temp = nodes.get(f-1).par;
			toPrint.add(nodes.get(temp-1));
			//System.out.print(nodes.get(temp).gIndex);
			f=temp;
		}
		int s=0;
		int v1=0,v2=0,a,b;
		for(int z=toPrint.size()-1;z>=0;z--){
			if(toPrint.get(z).index==12)break;
			a=toPrint.get(z).index;
			b=toPrint.get(z-1).index;
			v1=(a+b)%5 +1;
			v2=v1*(5-v[a][b]);
			s+=v2;
		}		
		System.out.println();
		System.out.println("Dissimilarity is  " + s );		
		
		
		System.out.println("The Propagating path is");
		//ArrayList<String>finalToPrint = new ArrayList<String>(toPrint.size());
		for(int i=toPrint.size()-1;i>=0;i--){
			printNode(toPrint.get(i));
		}
	}
	public static void ucs(){
		initialize(mvs);
		MV start = mvs.get(0);
		//start.mindistance=0;
		queue1.add(start);
		start.visted=true;
		System.out.println("Greedy Traversal sequence");
		//printNode(start)
;		//System.out.println();
		//start.isvisited=true;
		while(!queue1.isEmpty()) {
			/*for(int k=0;k<queue1.size();k++) {
				System.out.println(queue1.get(k).gIndex + "   " + queue1.get(k).mindistance);
				
			}
			System.out.println();
			System.out.println();
			System.out.println();*/
			MV mv = queue1.remove(0);
			printNode(mv);
			if(mv==mvs.get(11)){
				printstichingcurve(12,mvs);
				return;
			}
			else {
			for(MV c:mv.adj){
				if(c.visted==false){
					//printNode(c);
					c.par=mv.index;
					c.parent=mv;
					c.visted=true;
					queue1.add(c);
					sort(queue1);
				}
				}
			}
		}
		
		clear();
		//printstichingcurve(38,mvs);
	}
	 private static void sort(ArrayList<MV> queue12) {
			// TODO Auto-generated method stub
			 //for(int i=0;i<queue12.size();i++){
				// for(int j=0;j<queue12.size()-1;j++){
					//if()
				 //}
			 //}
			 //MV temp;
			 for(int i=1;i<queue12.size();i++){
				 for(int j=0;j<(queue12.size()-i);j++){
					 if(queue12.get(j).heuristics > queue12.get(j+1).heuristics)
					 {
						 MV t1=queue12.get(j);
						 MV t2 = queue12.get(j+1);
						 /*temp=t1;
						 t1 = t2;
						 t2=temp;*/
						 queue12.set(j,t2);
						 queue12.set(j+1,t1);
					 }
				 }
			 }
		 
		
	}
	public static void printNode(MV mvs){
		System.out.print(mvs.name + " ");
	}
	
		public static void main(String args[]){
		MV m1=new MV(1, 12, "m1");
		MV m2=new MV(2, 10, "m2");
		MV m3=new MV(3, 9, "m3");
		MV m4=new MV(4, 10, "m4");
		MV m5=new MV(5, 7, "m5");
		MV m6=new MV(6, 6, "m6");
		MV m7=new MV(7, 7, "m7");
		MV m8=new MV(8, 6, "m8");
		MV m9=new MV(9, 4, "m9");
		MV m10=new MV(10, 4, "m10");
		MV m11=new MV(11, 3, "m11");
		MV m12=new MV(12, 0, "m12");
		m1.adj.add(m2);	m1.adj.add(m3);	m1.adj.add(m4);
		m2.adj.add(m1);m2.adj.add(m5);m2.adj.add(m6);m2.adj.add(m8);
		m3.adj.add(m1);m3.adj.add(m5);m3.adj.add(m6);m3.adj.add(m7);
		m4.adj.add(m1);m4.adj.add(m5);m4.adj.add(m7);m4.adj.add(m8);
		m5.adj.add(m2);m5.adj.add(m3);m5.adj.add(m4);m5.adj.add(m9);
		m6.adj.add(m2);m6.adj.add(m3);m6.adj.add(m9);m6.adj.add(m10);
		m7.adj.add(m3);m7.adj.add(m4);m7.adj.add(m9);m7.adj.add(m11);
		m8.adj.add(m2);m8.adj.add(m4);m8.adj.add(m10);
		m9.adj.add(m5);m9.adj.add(m6);m9.adj.add(m7);m9.adj.add(m12);
		m10.adj.add(m6);m10.adj.add(m8);m10.adj.add(m12);
		m11.adj.add(m7);m11.adj.add(m12);
		m12.adj.add(m9);m12.adj.add(m10);m12.adj.add(m11);
		
		
		mvs.add(m1);mvs.add(m2);mvs.add(m3);mvs.add(m4);mvs.add(m5);mvs.add(m6);
		mvs.add(m7);mvs.add(m8);mvs.add(m9);mvs.add(m10);mvs.add(m11);mvs.add(m12);
		ucs();
		MV mn1=new MV(1, 12, "m1");
		MV mn2=new MV(2, 10, "m2");
		MV mn3=new MV(3, 9, "m3");
		MV mn4=new MV(4, 10, "m4");
		MV mn5=new MV(5, 7, "m5");
		MV mn6=new MV(6, 6, "m6");
		MV mn7=new MV(7, 7, "m7");
		MV mn8=new MV(8, 6, "m8");
		MV mn9=new MV(9, 4, "m9");
		MV mn10=new MV(10, 4, "m10");
		MV mn11=new MV(11, 3, "m11");
		MV mn12=new MV(12, 0, "m12");
		mn1.adj.add(mn2);	mn1.adj.add(mn3);mn1.adj.add(mn4);
		mn2.adj.add(mn1);mn2.adj.add(mn5);mn2.adj.add(mn6);mn2.adj.add(mn8);
		mn3.adj.add(mn1);mn3.adj.add(mn5);mn3.adj.add(mn6);mn3.adj.add(mn7);
		mn4.adj.add(mn1);mn4.adj.add(mn5);mn4.adj.add(mn7);mn4.adj.add(mn8);
		mn5.adj.add(mn2);mn5.adj.add(mn3);mn5.adj.add(mn4);mn5.adj.add(mn9);
		mn6.adj.add(mn2);mn6.adj.add(mn3);mn6.adj.add(mn9);mn6.adj.add(mn10);
		mn7.adj.add(mn3);mn7.adj.add(mn4);mn7.adj.add(mn9);mn7.adj.add(mn11);
		mn8.adj.add(mn2);mn8.adj.add(mn4);mn8.adj.add(mn10);
		mn9.adj.add(mn5);mn9.adj.add(mn6);mn9.adj.add(mn7);mn9.adj.add(mn12);
		mn10.adj.add(mn6);mn10.adj.add(mn8);mn10.adj.add(mn12);
		mn11.adj.add(mn7);mn11.adj.add(mn12);
		mn12.adj.add(mn9);mn12.adj.add(mn10);mn12.adj.add(mn11);
		
		
		amvs.add(mn1);amvs.add(mn2);amvs.add(mn3);amvs.add(mn4);amvs.add(mn5);amvs.add(mn6);
		amvs.add(mn7);amvs.add(mn8);amvs.add(mn9);amvs.add(mn10);amvs.add(mn11);amvs.add(mn12);
		as();
		
		}
}
	

