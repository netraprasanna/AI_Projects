import java.util.ArrayList;


public class MinMax {
	 int tempMat[][] = {
			{1,2,0,1,2,0},
			{2,1,0,2,0,2},
			{1,2,1,0,2,0},
			{2,0,0,0,1,0},
			{1,0,1,2,1,0},
			{1,2,1,0,1,1}
		};
	 //Return the number of nodes created
	 public int valReturn(){
		 return nCB;
	 }
	 //	Dummy constructor
	 public void MinMax() {
		 
	 }
	 
	 //Variables
	 int tempText[][]=new int[6][6];
	 ArrayList<String> emp = new ArrayList<String>();
	 TempNode tt[][] = new TempNode[6][6];
	 Node n;
	 int count =0;
	 Node r = new Node();
	 ArrayList<String> curr = new ArrayList<String>();
	 ArrayList<Integer> max = new ArrayList<Integer>();
	 ArrayList<Node> Chn = new ArrayList<Node>();
	 int nCB =0;
	 
	 //Assigning Liberty
	public  void libcal(int i,int j){
		tt[i][j].LibValue = tt[i][j].libPos.size();
	}
	
	//Generate the board
	public   void geBoard() {
		tempText[0][0]=1;tempText[0][1]=2;tempText[0][2]=0;tempText[0][3]=1;
		tempText[0][4]=2;tempText[0][5]=0;tempText[1][0]=2;tempText[1][1]=1;
		tempText[1][2]=0;tempText[1][3]=2;tempText[1][4]=0;tempText[1][5]=2;
		tempText[2][0]=1;tempText[2][1]=2;tempText[2][2]=1;tempText[2][3]=0;
		tempText[2][4]=2;tempText[2][5]=0;tempText[3][0]=2;tempText[3][1]=0;
		tempText[3][2]=0;tempText[3][3]=0;tempText[3][4]=1;tempText[3][5]=0;
		tempText[4][0]=1;tempText[4][1]=0;tempText[4][2]=1;tempText[4][3]=2;
		tempText[4][4]=1;tempText[4][5]=0;tempText[5][0]=1;tempText[5][1]=2;
		tempText[5][2]=1;tempText[5][3]=0;tempText[5][4]=1;tempText[5][5]=1;
		
	}
	//Clean the board and call methods for connectivity and liberty
	public  void clean(Node cur, Node n){
		geBoard();
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				tt[i][j].connComp.clear();
				tt[i][j].libPos.clear();
				tt[i][j].LibValue=2;
			}
		}
		int i,j;
		String [] s = n.name.split(",");
		i=Integer.parseInt(s[0]);
		j=Integer.parseInt(s[1]);
		tempText[i][j] = n.type;
		Node p=n.parent;
		while(p.name!="-1,-1"){
			s=p.name.split(",");
			i=Integer.parseInt(s[0]);
			j=Integer.parseInt(s[1]);
			if(tempText[i][j]!=-1)
			tempText[i][j]=p.type;
			for(int k=0;k<p.invalid.size();k++){
				s=p.invalid.get(k).split(",");
				i=Integer.parseInt(s[0]);
				j=Integer.parseInt(s[1]);
				tempText[i][j]=-1;
			}
			p=p.parent;
		}
		fuse(n);
		//System.out.println();
	}
	
	
	public  void calConnect() {
		int flag;
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				flag=0;
				//Left
				if(j-1>=0)
				if(tempText[i][j-1]==tempText[i][j]){
					for(int k=0;k<tt[i][j].connComp.size();k++)
						if(tt[i][j].connComp.get(k).equals(i+","+(j-1)))
						{
							flag=1;
							break;
						}
					if(flag==0)
						tt[i][j].connComp.add(i+","+(j-1));
				}
				//Top 
				
				flag=0;
				if(i-1>=0)
					if(tempText[i-1][j]==tempText[i][j]){
						for(int k=0;k<tt[i][j].connComp.size();k++)
							if(tt[i][j].connComp.get(k).equals((i-1)+","+j))
							{
								flag=1;
								break;
							}
						if(flag==0)
							tt[i][j].connComp.add((i-1)+","+j);
					}
				
				//Right 
				
				flag=0;
				if(j+1<6)
					if(tempText[i][j+1]==tempText[i][j]){
						for(int k=0;k<tt[i][j].connComp.size();k++)
							if(tt[i][j].connComp.get(k).equals(i+","+(j+1)))
							{
								flag=1;
								break;
							}
						if(flag==0)
							tt[i][j].connComp.add(i+","+(j+1));
					}
				
				//Down 
				
				flag=0;
				if(i+1<6)
					if(tempText[i+1][j]==tempText[i][j]){
						for(int k=0;k<tt[i][j].connComp.size();k++)
							if(tt[i][j].connComp.get(k).equals((i+1)+","+j))
							{
								flag=1;
								break;
							}
						if(flag==0)
							tt[i][j].connComp.add((i+1)+","+j);
					}
				if(tt[i][j].connComp.size()>0)
					
					for(int a=0;a<tt[i][j].connComp.size();a++){
						curr.add(tt[i][j].connComp.get(a));
					}
				String [] s1;
				int f,g;
				while(curr.size()!=0){
					s1=curr.get(0).split(",");
					f=Integer.parseInt(s1[0]);
					g=Integer.parseInt(s1[1]);
					curr.remove(0);
					connecComp(f,g,i,j);
				}
				}
			
		}
	}
		
	public   void connecComp(int f,int g,int i, int j){
		int flag=0;
		
		//left
		flag=0;
		if(g-1>=0)
			if(tempText[f][g-1]==tempText[f][g]){
				for(int k=0;k<tt[i][j].connComp.size();k++){
					if(tt[i][j].connComp.get(k).equals(f+","+(g-1))){
						flag=1;
						break;
					}
				}
				if(flag==0){
					tt[i][j].connComp.add(f+","+(g-1));
					curr.add(f+","+(g-1));
				}
			}
		
		//top
		flag=0;
		if(f-1>=0)
			if(tempText[f-1][g]==tempText[f][g]){
				for(int k=0;k<tt[i][j].connComp.size();k++){
					if(tt[i][j].connComp.get(k).equals((f-1)+","+g)){
						flag=1;
						break;
					}
				}
				if(flag==0){
					tt[i][j].connComp.add((f-1)+","+g);
					curr.add((f-1)+","+g);
				}
			}
		
		//right
		flag=0;
		if(g+1<6)
		if(tempText[f][g+1]==tempText[f][g]){
			for(int k=0;k<tt[i][j].connComp.size();k++){
				if(tt[i][j].connComp.get(k).equals(f+","+(g+1))){
					flag=1;
					break;
				}
			}
			if(flag==0){
				tt[i][j].connComp.add(f+","+(g+1));
				curr.add(f+","+(g+1));
			}
		}
		
		flag=0;
		if(f+1<6)
			if(tempText[f+1][g]==tempText[f][g]){
				for(int k=0;k<tt[i][j].connComp.size();k++){
					if(tt[i][j].connComp.get(k).equals((f+1)+","+g)){
						flag=1;
						break;
					}
				}
				if(flag==0){
					tt[i][j].connComp.add((f+1)+","+g);
					curr.add((f+1)+","+g);
				}
			}
	}
	public   void fuse(Node n){
		calConnect();
		caliLiberty(n);
		
		
	}
	//Main Liberty calculation
	public   void mainLiberty(int i, int j, int f, int g){
		int flag=0;
		
		//left
		flag=0;
		if(g-1>=0)
		if(tempText[f][g-1]==2){
			for(int k=0;k<tt[i][j].libPos.size();k++)
				if(tt[i][j].libPos.get(k).equals(f+","+(g-1))){
					flag=1;
					break;
				}
			
			if(flag==0){
				tt[i][j].libPos.add(f+","+(g-1));
			}
		}
		
		//top
		flag=0;
		if(f-1>=0)
			if(tempText[f-1][g]==2)
			{
				for(int k=0;k<tt[i][j].libPos.size();k++)
					if(tt[i][j].libPos.get(k).equals((f-1)+","+g)){
						flag=1;
						break;
					}
				
				if(flag==0){
					tt[i][j].libPos.add((f-1)+","+g);
				}	
			}
		
		//right
		flag=0;
		if(g+1<6)
			if(tempText[f][g+1]==2){
				for(int k=0;k<tt[i][j].libPos.size();k++)
					if(tt[i][j].libPos.get(k).equals(f+","+(g+1))){
						flag=1;
						break;
					}
				
				if(flag==0){
					tt[i][j].libPos.add(f+","+(g+1));
				}
			}
		
		//down
		flag=0;
		if(f+1<6)
			if(tempText[f+1][g]==2){
				for(int k=0;k<tt[i][j].libPos.size();k++)
					if(tt[i][j].libPos.get(k).equals((f+1)+","+g)){
						flag=1;
						break;
					}
				
				if(flag==0){
					tt[i][j].libPos.add((f+1)+","+g);
				}
			}
		
	}
	
	
	//Calling Liberty
	public   void liberty(int i, int j){
		String [] s;int f,g;
		for(int k=0;k<tt[i][j].connComp.size();k++){
			s=tt[i][j].connComp.get(k).split(",");
			f=Integer.parseInt(s[0]);
			g=Integer.parseInt(s[1]);
			mainLiberty(i,j,f,g);
		}
		if(tt[i][j].connComp.size()==0)
			mainLiberty(i,j,i,j);
	}
	
	public   void caliLiberty(Node n){
		for(int i=0;i<6;i++)
			for(int j=0;j<6;j++)
				 if(tempText[i][j]!=2)
					 liberty(i,j);
		
		for(int i=0;i<6;i++)
			for(int j=0;j<6;j++)
				if(tempText[i][j]!=2)
					libcal(i,j);
		
		for(int i=0;i<6;i++)
			for(int j=0;j<6;j++)
				if(tt[i][j].LibValue==0){
					//System.out.println("added " +i + "," +j+ "to node " + n.name );
					n.invalid.add(i+","+j);
				}
				
				
	}
	
	//Start method to create the tree
	public  void start() {
		count =0;
		emp.add("0,1");
		emp.add("0,4");
		emp.add("1,0");
		emp.add("1,3");
		emp.add("1,5");
		emp.add("2,1");
		emp.add("2,4");
		emp.add("3,0");
		emp.add("4,3");
		emp.add("5,1");
		
		for(int t=0;t<6;t++)
			for(int s=0;s<6;s++)
				tt[t][s]= new TempNode();
		
		for(int t=0;t<6;t++)
			for(int s=0;s<6;s++)
				tempText[t][s]=2;
		
		

		r.conf=tempMat;
		r.name = -1 + "," + -1;
		r.parent = null;
		r.parentName=null;
		r.value = 0;
		
		for(int i=0;i<emp.size();i++){
			Node temp=new Node();
			temp.name=emp.get(i);
			temp.parent=r;
			temp.parentName=r.name;
			temp.type=0;
			r.children.add(temp);
			nCB++;
			clean(r,temp);
		}
		count =1;
		//System.out.println("Start Level 1");
		for(int j=0;j<r.children.size();j++){
			String [] s1 = r.children.get(j).name.split(",");
			int i=Integer.parseInt(s1[0]);
			int j1=Integer.parseInt(s1[1]);
			//System.out.print("(" + (j1+1) + "," + (i+1)+ ")");
			//System.out.print("(" + r.children.get(j).name + ")");
		}
		//System.out.println();
		//System.out.println("Done with Level 1");
		
		for(int j=0;j<r.children.size();j++){
			
			for(int i=0;i<emp.size();i++){
				if(r.children.get(j).name == emp.get(i)){
					continue;
				}else {
					Node temp = new Node();
					temp.name=emp.get(i);
					temp.parentName=r.children.get(j).name;
					temp.parent = r.children.get(j);
					temp.type=1;
					Node t= r.children.get(j);
					t.children.add(temp);
					nCB++;
					clean(t,temp);
				}
			}
			
		}
		count =2;
		//System.out.println();
		//System.out.println("Start Level 2");
		for(int k=0;k < r.children.size();k++){
			Node t = r.children.get(k);
			//System.out.println();
			String [] s1 = t.name.split(",");
			int i=Integer.parseInt(s1[0]);
			int j=Integer.parseInt(s1[1]);
			//System.out.println("(" + (j+1) + "," + (i+1)+ ")");
			
			for(int l=0; l < t.children.size();l++){
				String [] s2 = t.children.get(l).name.split(",");
				int i1=Integer.parseInt(s2[0]);
				int j1=Integer.parseInt(s2[1]);
				//System.out.print("(" + (j1+1) + "," + (i1+1)+ ")");
				//System.out.print("(" + t.children.get(l).name + ")");
			}
		}
		
		//System.out.println();
		//System.out.println("Done with Level 2");
		
		//System.out.println();
		//System.out.println("Start Level 3");

		for(int i=0;i<r.children.size();i++) {
			Node t = r.children.get(i);
			int flag;
			for(int j=0;j<t.children.size();j++) {
				Node current = t.children.get(j);
				for(int k=0;k<emp.size();k++){
					Node temp=new Node();
					Node p = current;
					temp.name=emp.get(k);
					flag=0;
					temp.type=0;
					temp.parent=current;
					temp.parentName=current.name;
					
					while(p.name!="-1,-1"){
						if(emp.get(k).equals(p.name)){
							flag=1;
							break;
						}
						p=p.parent;
					}
					if(flag==1)continue;
					for(int c=0;c<current.children.size();c++){
						if(current.children.get(c).name.equals(emp.get(k)))
						continue;
					}
						current.children.add(temp);
						nCB++;
						clean(current,temp);
				}
				/*if(r.children.get(i).name == t.children.get(j).name){
					continue;
				}else {
					for(int k=0;k<emp.size();k++){
						if(t.children.get(j).name == emp.get(k)){
							continue;
						}else {
							Node temp = new Node();
							temp.name=emp.get(k);
							temp.parentName=t.children.get(j).name;
							temp.parent = t.children.get(j);
							temp.type=1;
							Node tl= t.children.get(j);
							tl.children.add(temp);
							
						}
					}
				}*/
			}
		}
		count=3;
		
		for(int i=0;i<r.children.size();i++){
			Node t = r.children.get(i);
			//System.out.println();
			String [] s1 = t.name.split(",");
			int i1=Integer.parseInt(s1[0]);
			int j1=Integer.parseInt(s1[1]);
			//System.out.println("(" + (j1+1) + "," + (i1+1)+ ")");
			for(int j=0;j<t.children.size();j++){
				Node k=t.children.get(j);
				//System.out.println();
				String [] s2 = k.name.split(",");
				int i2=Integer.parseInt(s2[0]);
				int j2=Integer.parseInt(s2[1]);
				//System.out.println("(" + (j2+1) + "," + (i2+1)+ ")");
				for(int l=0;l<k.children.size();l++){
					String [] s3 = k.children.get(l).name.split(",");
					int i3=Integer.parseInt(s3[0]);
					int j3=Integer.parseInt(s3[1]);
					//System.out.print("(" + (j3+1) + "," + (i3+1)+ ")");
					//System.out.print("(" + k.children.get(l).name + ")");	
				}
			}
		}
		

		//System.out.println();
		//System.out.println("Done Level 3");
		
		
		//System.out.println();
		//System.out.println("Start Level 4");

		
		for(int i=0;i<r.children.size();i++) {
			Node t = r.children.get(i);
			int flag;
			for(int j=0;j<t.children.size();j++) {
				Node s = t.children.get(j);
				for(int k=0;k<s.children.size();k++){
					Node current=s.children.get(k);
					for(int l=0;l<emp.size();l++){
						Node temp=new Node();
						Node p = current;
						temp.name=emp.get(l);
						flag=0;
						temp.type=1;
						temp.parent=current;
						temp.parentName=current.name;
						
						while(p.name!="-1,-1"){
							if(emp.get(l).equals(p.name)){
								flag=1;
								break;
							}
							p=p.parent;
						}
						if(flag==1)continue;
						for(int c=0;c<current.children.size();c++){
							if(current.children.get(c).name.equals(emp.get(l)))
							continue;
						}
							current.children.add(temp);
							nCB++;
							clean(current,temp);
			}
		}
	}
}
		count =4;
		for(int i=0;i<r.children.size();i++){
			Node t = r.children.get(i);
			//System.out.println();
			String [] s1 = t.name.split(",");
			int i1=Integer.parseInt(s1[0]);
			int j1=Integer.parseInt(s1[1]);
			//System.out.println("(" + (j1+1) + "," + (i1+1)+ ")");
			//System.out.println("(" + t.name + ")");
			for(int j=0;j<t.children.size();j++){
				Node k=t.children.get(j);
				//System.out.println();
				String [] s2 = k.name.split(",");
				int i2=Integer.parseInt(s2[0]);
				int j2=Integer.parseInt(s2[1]);
				//System.out.println("(" + (j2+1) + "," + (i2+1)+ ")");
				for(int l=0;l<k.children.size();l++){
					Node s = k.children.get(l);	
					//System.out.println();
					String [] s3 = s.name.split(",");
					int i3=Integer.parseInt(s3[0]);
					int j3=Integer.parseInt(s3[1]);
					//System.out.println("(" + (j3+1) + "," + (i3+1)+ ")");
					for(int m=0;m<s.children.size();m++){
						String [] s4 = s.children.get(m).name.split(",");
						int i4=Integer.parseInt(s4[0]);
						int j4=Integer.parseInt(s4[1]);
						//System.out.print("(" + (j4+1) + "," + (i4+1)+ ")");
						
						//System.out.print("(" + s.children.get(m).name + ")");
					}
				}
			}
		}
		//System.out.println();
		//System.out.println("Done Level 4");
		finalBuild();
		minmax();
		
	}
	
	 public void finalBuild(){
		 for(int i=0;i<r.children.size();i++){
			 Node Level1=r.children.get(i);
			 for(int j=0;j<Level1.children.size();j++){
				 Node Level2 = Level1.children.get(j);
				 for(int k=0;k<Level2.children.size();k++){
					 Node Level3 = Level2.children.get(k);
					 for(int l=0;l<Level3.children.size();l++) {
						 Node Level4=Level3.children.get(l);
						 lastClean(Level4);
					 }
				 }
			 }
		 }
	 }
	 
	 public void lastClean(Node n){
		 geBoard();
		 for(int i=0;i<6;i++){
			 for(int j=0;j<6;j++){
				 tt[i][j].connComp.clear();
				 tt[i][j].libPos.clear();
				 tt[i][j].LibValue=2;
			 }
		 }
		 int i,j;
		 String []temp;
		 
		 Node p = n;
		 while(p.name!="-1,-1"){
			 temp = p.name.split(",");
			 i=Integer.parseInt(temp[0]);
			 j=Integer.parseInt(temp[1]);
			 if(tempText[i][j]!=-1)
				 tempText[i][j]=p.type;
			 
			 //System.out.println("parent name " + p.name);
			 
			 for(int k=0;k<p.invalid.size();k++){
				 temp=p.invalid.get(k).split(",");
				 i=Integer.parseInt(temp[0]);
				 j=Integer.parseInt(temp[1]);
				 tempText[i][j]=-1;
			 }
			 p=p.parent;
		 }
		 //System.out.println();
		 //System.out.println("Level 4 name :" + n.name);
		 for(int l=0;l<6;l++){
			 for(int m=0;m<6;m++){
				 //System.out.print(tempText[l][m] + "");
				 
			 }
			// System.out.println();
		 }
		 
		 calValue(n);
		 
		 //System.out.println();
		 //System.out.println(n.name + "s.value is " + n.value);
		 
		 
	 }
	 
	 public void minmax(){
		 //System.out.println("Naveen");
		 for(int a=0;a<r.children.size();a++){
			 Node Level1 = r.children.get(a);
			 for(int b=0;b<Level1.children.size();b++){
				 Node Level2 = Level1.children.get(b);
				 for(int c=0;c<Level2.children.size();c++){
					 Node Level3 = Level2.children.get(c);
					 for(int d=0;d<Level3.children.size();d++){
						 max.add(Level3.children.get(d).value);
					 }
					 sort();
					 Level3.value=max.get(max.size()-1);
					 max.clear();
				 }
			 }
		 }
		 
		 for(int a=0;a<r.children.size();a++){
			 Node Level1 = r.children.get(a);
			 for(int b=0;b<Level1.children.size();b++){
				 Node Level2 = Level1.children.get(b);
				 for(int c=0;c<Level2.children.size();c++){
					 max.add(Level2.children.get(c).value);
				 }
				 sort();
				 Level2.value=max.get(0);
				 max.clear();
			 }
		 }
		 
		 for(int a=0;a<r.children.size();a++){
			 Node Level1 = r.children.get(a);
			 for(int b=0;b<Level1.children.size();b++){
				 max.add(Level1.children.get(b).value);
			 }
			 sort();
			 Level1.value=max.get(max.size()-1);
			 max.clear();
			 }
			 
		 for(int a=0;a<r.children.size();a++){
			 Node p = r.children.get(a);
			 //System.out.println(p.name + ":" + p.value);
		 
		 
 }
		  maxDec();
	 }
	 
	 public void maxDec() {
		 Node first = r.children.get((r.children.size())-2);
		 String [] t = first.name.split(",");
		 Integer a,b;
		 a=Integer.parseInt(t[0]);
		 b=Integer.parseInt(t[1]);
		 String s;
		 s="(" + (b+1) + "," + (a+1) + ")";
		 System.out.println("Best Strategy :");
		 System.out.println("Depth 0 : Player B places stone at "+s);
		 for(int i=0;i<first.children.size();i++){
			 Chn.add(first.children.get(i));
		 }
		// System.out.println();
		// for(int j=0;j<Chn.size();j++)
		// {
		 //System.out.print(" "+Chn.get(j).name+ " "+ Chn.get(j).value);
		//}
		 //System.out.println();
		 sortChildren();		 
		 t = Chn.get(2).name.split(",");
		 a=Integer.parseInt(t[0]);
		 b=Integer.parseInt(t[1]);
		 s="(" + (b+1) + "," + (a+1) +")";
		 System.out.println("Depth 1: Player W places stone at "+s);
		 Node q=Chn.get(2);
		  Chn.clear();
		 for(int i=0;i<q.children.size();i++) {
		 	 Chn.add(q.children.get(i));
		 }
		 sortChildren();
		 t = Chn.get(4).name.split(",");
		 a=Integer.parseInt(t[0]);
		 b=Integer.parseInt(t[1]);
		 s="(" + (b+1) + "," + (a+1) +")";
		 System.out.println("Depth 2: Player B places stone at "+s);
		 Node r=Chn.get(4);
		 //now
		 //Node r=cn.get((cn.size())-1);
		 Chn.clear();
		 for(int i=0;i<r.children.size();i++) {
		 //a.add(p.children.get(i).value);
		 Chn.add(r.children.get(i));
		 }
		 sortChildren();
		 t = Chn.get(0).name.split(",");
		 a=Integer.parseInt(t[0]);
		 b=Integer.parseInt(t[1]);
		 s="(" + (b+1) + "," + (a+1) +")";
		 System.out.println("Depth 3: Player W places stone at "+s);
		 Node s1=Chn.get(0);
		 System.out.println("Depth 4: Utility value of current board configuration "+s1.value);
	 }
	/* public void shit() {
		 Node p=r.children.get((r.children.size())-2);
		 String[] temp = p.name.split(",");
		 Integer a,b;
		 a=Integer.parseInt(temp[0]);
		 b=Integer.parseInt(temp[1]);
		 String s;
		 s="(" + (b+1) + "," + (a+1) +")";
		 System.out.println("Best Strategy:");
		 System.out.println("Depth 0: Player B places stone at "+s);
		 for(int i=0;i<p.children.size();i++){
		 //a.add(p.children.get(i).value);
		 Chn.add(p.children.get(i));
		 }
		 sortChildren();
		 //printing cn
		// System.out.println();
		// for(int j=0;j<Chn.size();j++)
		// {
		 //System.out.print(" "+Chn.get(j).name+ " "+ Chn.get(j).value);
		 //}
		 //System.out.println();
		 //now
		 //System.out.println("Depth 1: Player W places stone at "+cn.get(0).name);
		 temp = Chn.get(2).name.split(",");
		 a=Integer.parseInt(temp[0]);
		 b=Integer.parseInt(temp[1]);
		 s="(" + (b+1) + "," + (a+1) +")";
		 System.out.println("Depth 1: Player W places stone at "+s);
		 Node q=Chn.get(2);
		 //now
		 //Node q=cn.get(0);
		 Chn.clear();
		 for(int i=0;i<q.children.size();i++) {
		 //a.add(p.children.get(i).value);
			 Chn.add(q.children.get(i));
		 }
		 sortChildren();
		 //System.out.println();
		 //for(int j=0;j<Chn.size();j++)
		 //{
		 //System.out.print(" "+Chn.get(j).name+ " "+ Chn.get(j).value);
		 //}
		 //System.out.println();
		 //now
		 //System.out.println("Depth 2: Player B places stone at "+cn.get((cn.size())-1).name);
		 temp = Chn.get(4).name.split(",");
		 a=Integer.parseInt(temp[0]);
		 b=Integer.parseInt(temp[1]);
		 s="(" + (b+1) + "," + (a+1) +")";
		 System.out.println("Depth 2: Player B places stone at "+s);
		 Node r=Chn.get(4);
		 //now
		 //Node r=cn.get((cn.size())-1);
		 Chn.clear();
		 for(int i=0;i<r.children.size();i++) {
		 //a.add(p.children.get(i).value);
		 Chn.add(r.children.get(i));
		 }
		 sortChildren();
		 //System.out.println();
		 //for(int j=0;j<Chn.size();j++)
		 //{
		 //System.out.print(" "+Chn.get(j).name+ " "+ Chn.get(j).value);
		 //}
		 //System.out.println();
		 temp = Chn.get(0).name.split(",");
		 a=Integer.parseInt(temp[0]);
		 b=Integer.parseInt(temp[1]);
		 s="(" + (b+1) + "," + (a+1) +")";
		 System.out.println("Depth 3: Player W places stone at "+s);
		 Node s1=Chn.get(0);
		 System.out.println("Depth 4: Utility value of current board configuration "+s1.value);
		 
		// System.out.println("Total number of Nodes : " + nCB);
		 }*/
	 
	 
	 public void sortChildren(){
		 for(int i=1;i<Chn.size();i++){
			 for(int j=0;j<Chn.size()-i;j++){
				 if(Chn.get(j).value > Chn.get(j+1).value){
					 Node t1 = Chn.get(j);
					 Node t2 = Chn.get(j+1);
					 Chn.set(j,t2);
					 Chn.set(j+1,t1);
				 }
			 }
		 }
	 }
	 public void calValue(Node n){
		 int nBlacks =0,nWhites=0;
		 for(int i=0;i<6;i++){
			 for(int j=0;j<6;j++){
				 if(tempText[i][j]==0)
					 nBlacks++;
				 else if(tempText[i][j]==1)
					 nWhites++;
			 }
			 
		 }
		 n.value=nBlacks-nWhites;
		 //System.out.println("Value :" + n.value);
	 }
	 public void sort(){
		 for(int i=1;i<max.size();i++){
			 for(int j=0;j<max.size()-i;j++){
				 if(max.get(j) > max.get(j+1)){
					 Integer t1 = max.get(j);
					 Integer t2 = max.get(j+1);
					 max.set(j,t2);
					 max.set(j+1,t1);
				 }
			 }
		 }
	 }
}
