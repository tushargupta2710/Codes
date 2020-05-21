import java.util.*;
import java.io.*;


public class dijkstra {
    static ArrayList<node>[] edge_index;
    static ArrayList<Integer>[] edge_weight;

    static int[] solve(ArrayList<node>[] graph,int source){   

        PriorityQueue<node> pq = new PriorityQueue<node>((a,b)->a.val-b.val);

        int[] distance_from_source = new int[graph.length];
        Arrays.fill(distance_from_source,Integer.MAX_VALUE);
        distance_from_source[source]=0;
        node no  = new node(source,0);
        pq.add(no);
        Set<Integer> set = new HashSet<>();
        while(set.size()<graph.length && pq.size()>0){
            int x = -1;
            node m = pq.poll();
        if(!set.contains(m.vert) ){
            x= m.vert;
            set.add(x);
            if(graph[x].size()!=0){
                for(int i=0;i<graph[x].size();i++){
                    
                    node temp = graph[x].get(i);
                    int y = temp.vert;
                    int wt = temp.val;
                    //System.out.println(wt+" "+cost[x][y]);
                    if(distance_from_source[x]!=Integer.MAX_VALUE && distance_from_source[x]+wt<distance_from_source[y]){
                        distance_from_source[y] = distance_from_source[x]+wt;
                        pq.add(new node(y,distance_from_source[y]));
                    }
                }
            }
        }
        }
        // finally distance_from_source contains minimum cost for each vertex from source;
        //costly roads;
        // for(int i =0;i<distance_from_source.length;i++){

        //      if(i!=source && distance_from_source[i]!=Integer.MAX_VALUE)
        //         System.out.print(distance_from_source[i]+" ");
        //     else if(i!=source)
        //         System.out.print(-1+" ");
        // }
        return distance_from_source;
    }
	public static void main(String[] args) throws IOException{
		Reader r = new Reader();
		Reader.init(System.in);
		
            int n = r.nextInt();
            int e = r.nextInt();
            int q = r.nextInt();
            ArrayList<node>[] graph = new ArrayList[n];
            //ArrayList<Integer>[] edge_weight = new ArrayList[n];
            for(int i=0;i<n;i++){
                graph[i] = new ArrayList<node>();
                //edge_weight[i] = new ArrayList<Integer>();
            }
            
            for(int k=0;k<e;k++){
                int i = r.nextInt()-1;
                int j = r.nextInt()-1;
                int c = r.nextInt();
                graph[i].add(new node(j,c));
                graph[j].add(new node(i,c));
                // edge_weight[i].add(c);
                // edge_weight[j].add(c);
                //if(cost[i][j]>c)
                //cost[i][j]=c;
                //if(cost[j][i]>c)
                //cost[j][i]=c;
            }
            int[] aunts = new int[q];
            for(int i=0;i<q;i++){
                aunts[i] = r.nextInt()-1;
            }
            int home = r.nextInt()-1;
            int inst = r.nextInt()-1; 
            //int s = r.nextInt();
            int[] dist_home = solve(graph,home);
            int[] dist_inst = solve(graph,inst);
            int min = Integer.MAX_VALUE;

            for(int i=0;i<q;i++){
                int a = aunts[i];
                min = Math.min(min,dist_home[a]+dist_inst[a]);
            }
            System.out.println(min);
    }
	
}

// cost 2-d array is getting overwrite.
/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

class node {
    int vert;
    int val;// cost to rreach
    node(int v,int va){
        vert=v;
        val=va;
    }
}

