import java.util.*;
//recursive dfs


// to find totsl number of paths, we use dfs and do not keep track of visited node,/ or mark node unvisited when its list is completely checked;

 class dfs_recursive{
	static int n;
	static LinkedList<Integer> array[];
	//constructor
	dfs_recursive(int N){
		n=N;
		array = new LinkedList[n];
		for(int i=0;i<n;i++){
			array[i] = new LinkedList<Integer>();
		}
	}
	//directed
	static void addedge(int a,int b){
		array[a].add(b);
	}

	static void dfs(int s, boolean visited[]){
		visited[s]=true;
		System.out.println(s);
		for(int i=0;i<array[s].size();i++){
			int x = array[s].get(i);
			if(!visited[x]){
				dfs(x,visited);
			}
		}


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		dfs_recursive graph = new dfs_recursive(n);
		for(int i=0;i<e;i++){
			graph.addedge(sc.nextInt(),sc.nextInt());
		}
		boolean[] visited = new boolean[n];
		graph.dfs(2,visited);
	}

}









