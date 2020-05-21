import java.util.*;
//recursive dfs
class gfg{
	static int n;
	static LinkedList<Integer> array[];
	//constructor
	gfg(int N){
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

	static void dfs(int s, boolean visited[],int d,int count){
		visited[s]=true;
	    //System.out.println(s);
		for(int i=0;i<array[s].size();i++){
			int x = array[s].get(i);
			if(x==d)
					count++;
			if(!visited[x]){
				
				dfs(x,visited,d,count);
			}
		}


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		System.out.println("dfg");

		for(int k=0;k<t;k++){
		int n = sc.nextInt();
		int e = sc.nextInt();
		gfg graph = new gfg(n);
		for(int i=0;i<e;i++){
			graph.addedge(sc.nextInt(),sc.nextInt());
		}
		boolean[] visited = new boolean[n];
		int s = sc.nextInt();
		int d = sc.nextInt();
		int count=0;
		graph.dfs(s,visited,d,count);
		System.out.println("count "+count);
	}
}

}









