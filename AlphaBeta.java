import java.util.ArrayList;


public class AlphaBeta {
	
	int boardInit1[][] = {
			{1,2,0,1,2,0},
			{2,1,0,2,0,2},
			{1,2,1,0,2,0},
			{2,0,0,0,1,0},
			{1,0,1,2,1,0},
			{1,2,1,0,1,1}
	};
	public int init(){
		TempNode2 prune = new TempNode2();
		prune.leaf=false;
		
		int boardInit[][] = {
				{1,2,0,1,2,0},
				{2,1,0,2,0,2},
				{1,2,1,0,2,0},
				{2,0,0,0,1,0},
				{1,0,1,2,1,0},
				{1,2,1,0,1,1}
		};
		
		prune.board = boardInit;
		
		
		return pruneTree(prune,0,0);
		}
	
	public int pruneTree(TempNode2 root,int depth, int player){
		if(depth==4){
			int bc=0;
			int wc=0;
			for(int i=0;i<6;i++){
				for(int j=0;j<6;j++){
					if(root.board[i][j] == 0){
						bc++;
					}else if(root.board[i][j]==1){
						wc++;
					}
				}
			}
			
			root.value=bc-wc;
			root.leaf=true;
			root.alp=root.value;
			return root.value;
		} else {
			for(int i=0;i<6;i++){
				for(int j=0;j<6;j++){
					if(root.alp<root.beta){
					if(root.board[i][j]==2){
						if(player==1){
							TempNode2 nNode = new TempNode2();
							nNode.i=i;
							nNode.j =j;
							nNode.board=new int[6][6];
							//for(int a=0;a<6;a++)
								//for(int b=0;b<6;b++)
									//nNode.board[a][b]=boardInit1[a][b];
							//nNode.board=boardInit1;
							nNode.board = copyBoard(root.board);
							nNode.board[i][j]=player;
							nNode.leaf=false;
							nNode.value=9999;
							nNode.alp = root.alp;
							nNode.beta = root.beta;
							int [][]lNode = calLib(nNode.board);
							invalidate(nNode.board,lNode);
							root.chi.add(nNode);
							pruneTree(nNode, depth+1, 0);
							if(root.value==9999){
								root.value = nNode.value;
							}
							if(root.value>nNode.value){
								root.value=nNode.value;
							}
							
							if(root.beta>nNode.alp){
								root.beta = nNode.alp;
							}
						}else if(player==0){
							TempNode2 nNode = new TempNode2();
							nNode.i=i;
							nNode.j =j;
							nNode.board=new int[6][6];
							//for(int a=0;a<6;a++)
								//for(int b=0;b<6;b++)
									//nNode.board[a][b]=boardInit1[a][b];
							nNode.board = copyBoard(root.board);
							nNode.board[i][j]=player;
							nNode.leaf=false;
							nNode.value=9999;
							nNode.alp = root.alp;
							nNode.beta = root.beta;
							int [][]lNode = calLib(nNode.board);
							invalidate(nNode.board,lNode);
							root.chi.add(nNode);
							pruneTree(nNode, depth+1, 1);
							if(root.value==9999){
								root.value=nNode.value;
							}
							if(root.value<nNode.value){
								root.value=nNode.value;
							}
							if(root.alp<nNode.beta){
								root.alp=nNode.beta;
							}
						}
					}
					}
				else {
					return root.value;
				}
			}
		}
			return root.value;
	}
	}
	
	public int[][] copyBoard(int [][] input){
		int [][] target = new int[6][6];
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				target[i][j]=input[i][j];
			}
		}
		return target;
	}
	
	public int[][] calLib(int [][] board){
		int [][]lNode = new int[6][6];
		for(int a=0;a<6;a++){
			for(int b=0;b<6;b++){
				if(board[a][b] ==1 || board[a][b] ==0){
					int liberty=0;
					if((a-1)>=0 && board[a-1][b]==2){
						liberty++;
					}
					if((a+1)<6 && board[a+1][b]==2) {
						liberty++;
					}
					if((b-1)>=0 && board[a][b-1]==2){
						liberty++;
					}
					if((b+1)<6 && board[a][b+1]==2){
						liberty++;
					}
					lNode[a][b]=liberty;
				}
			}
		}
		return lNode;
	}
	
	
	public void invalidate(int [][] board, int [][]lNode){
		boolean [][] Visited = new boolean[6][6];
		for(int k=0;k<6;k++){
			for(int l=0;l<6;l++){
				if(!(board[k][l]==2) && lNode[k][l]==0){
					//if(!check(board,k,l,Visited,lNode)){
						board[k][l]=-1;
					//}
				}
			}
		}
	}
}

