import java.util.*;
import java.*;



// if we have to find the $$ LEVEL $$ of a node then we do bfs and then make level of new visited node to be lvel of the parent node +1;
// shortest path/ min number of edges between 2 nodes.(diff in levels of 2 nodes in shortest path)
public class bfs{
	int n ;
	LinkedList<Integer> array[];

	bfs(int N){
		n=N;
		array = new LinkedList[n];
		for(int i=0;i<n;i++){
			array[i]= new LinkedList<Integer>();
		}
	}
	void addedge(int s,int d){
		array[s].add(d);
	}
	void traversal(int s){
		boolean[] visited = new boolean[n];
		visited[s]=true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while(q.size()>0){
			int x = q.poll();
			for(int i=0;i<array[x].size();i++){
				if(visited[array[x].get(i)]==false){
					q.add(array[x].get(i));
					visited[array[x].get(i)]=true;
				}
			}
			System.out.println(x);

		}
	}


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int nodes= sc.nextInt();
		int edges = sc.nextInt();
		bfs graph = new bfs(nodes);
		for(int i=0;i<edges;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.addedge(a,b);
		}
		graph.traversal(2);

	}
}