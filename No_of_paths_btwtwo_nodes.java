import java.util.*;
import java.math.*;
import java.*;
//recursive dfs
public class No_of_paths_btwtwo_nodes{


    static int n;
    static int count=0;
    static LinkedList<Integer> array[];

    No_of_paths_btwtwo_nodes(int N){
        n=N;
        array = new LinkedList[n];
        for(int i=0;i<n;i++){
            array[i] = new LinkedList<Integer>();
        }
    }
    static void makeedge(int a ,int b){
        array[a].add(b);
    }
    static void dfs(int s,int d){
        //visited[s]=true;
        if(s==d)
            count++;
        System.out.println();
        for(int i=0;i<array[s].size();i++){
            //if(visited[array[s].get(i)]==false){
                //visited[array[s].get(i)]=true;
                System.out.print(s+" "+ array[s].get(i)+" ");
                dfs(array[s].get(i),d);

            }
            //System.out.println();
        }

        //visited[s]=false;


    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes= sc.nextInt();
        int edges = sc.nextInt();
        No_of_paths_btwtwo_nodes graph = new No_of_paths_btwtwo_nodes(nodes);
        for(int i=0;i<edges;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.makeedge(a,b);
        }
        boolean[] visited = new boolean[nodes];
        graph.dfs(0,5);

        System.out.println(graph.count);
        
        }
    }





            









