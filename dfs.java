import java.util.*;
import java.*;
public class dfs{

	int n;
	LinkedList<Integer> array[];
	dfs(int N){
		n=N;
		array = new LinkedList[n];
		for(int i=0;i<n;i++){
			array[i] = new LinkedList<Integer>();
		}
	}
	void addedge(int a , int b){
		array[a].add(b);

	}
	void traversal(int s){
		boolean[] visited = new boolean[n];
		visited[s]=true;
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(s);
		System.out.println(s);
		while(stack.size()>0){
			int x = stack.peek();
			int count=0;
			for(int i=0;i<array[x].size();i++){
				if(visited[array[x].get(i)]==false){
					visited[array[x].get(i)]=true;
					stack.push(array[x].get(i));
					System.out.println(array[x].get(i));
					count=1;
					break;
				}
			}
			if(count==0){
				stack.pop();
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int edges = sc.nextInt();
		dfs graph = new dfs(n);
		for(int i=0;i<edges;i++){
			graph.addedge(sc.nextInt(),sc.nextInt());
		}
		graph.traversal(0);
	}
}