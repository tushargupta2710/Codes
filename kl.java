import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

/**
 * 
 */

/**
 * @author Acer
 *
 */
public class kl {

	
		static void addEdge(LinkedList[] edges, int u, int v) 
		{ 
		edges[u].add(v); 
		//edges[v].add(u); 
		} 
		static int BFS(int[] arr, int n){
			boolean[] visited = new boolean[n+3];
			LinkedList<Integer> q = new LinkedList<>();
			if(arr[1]!=0)
				q.add(arr[1]);
			q.add(2);
			int ans=0;
			while(q.size()>0){
				int s = q.size();
				ans++;
				for(int k=0;k<s;k++){
					int x = q.poll();
					visited[x]=true;
					if(arr[x]!=0 && !visited[arr[x]]){
						if(arr[x]==n+1)
							return ans;
						q.add(arr[x]);
						
					}
					if(!visited[arr[x]+1]){
						q.add(arr[x]+1);
					}
					
					
						
					
				} 
			}
			return -1;
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int Test = sc.nextInt();
		for(int j = 0; j < Test; j++)
			{
				int N = sc.nextInt();
				int [] arr = new int[N+2];
				for (int i = 1; i < N+1; i++)
					{
						int x = sc.nextInt();
						if(i+x<=N+1 && i+x>=2){
							arr[i] = i+x;
						}

						
					}
				LinkedList<Integer>[] edges = new LinkedList[N+1];
				for (int i = 1; i < N+1; i++)
					{ 
						edges[i] = new LinkedList<Integer>(); 
					}
				for(int i = 1; i < N+1; i++)
					{
						addEdge(edges, i, i+1);
						if(i + arr[i] <= N+1 && i+arr[i]>=2)
							{
								addEdge(edges, i, i + arr[i]); 
							}
					}
				System.out.println(BFS(arr,N));
			}
	}
}