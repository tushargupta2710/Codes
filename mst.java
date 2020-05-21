import java.util.*;
import java.io.*;

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
    long val;// cost to rreach
    node(int v,long va){
        vert=v;
        val=va;
    }
}
public class mst {

    static long solve(ArrayList<Integer>[] graph,long[][] cost,int source){   

        // minimum cost to reach particular vertex i;


        PriorityQueue<node> pq = new PriorityQueue<node>((a,b)->(int)a.val-(int)b.val);
        node no  = new node(source,0);
        pq.add(no);
        long[] edgefor_vertex = new long[graph.length];
        Arrays.fill(edgefor_vertex,Long.MAX_VALUE);
        edgefor_vertex[source]=0;
        //set for visited vertices
        HashSet<Integer> set = new HashSet<>();
        while(set.size()<graph.length && pq.size()>0){

            // first part is to get the minimum vertex at each step.
            //int min = Integer.MAX_VALUE;
            int min_index = -1;
            node m = pq.poll();
            
        if(!set.contains(m.vert) ){
           // System.out.println(m.vert);
            min_index= m.vert;
            set.add(min_index);
            // evaluating and updating cost_for_vertex array for all the neighbous of min_index vertex.
            if(graph[min_index].size()!=0){
                for(int i=0;i<graph[min_index].size();i++){
                    int x = min_index;
                    int y = graph[min_index].get(i);
                    if(!set.contains(y) && cost[x][y]<edgefor_vertex[y]){
                        //cost_for_vertex[y] = cost_for_vertex[x]+cost[x][y];
                        edgefor_vertex[y] = cost[x][y];
                        pq.add(new node(y,edgefor_vertex[y]));
                    }
                }
            }
        }
        }
        // finally cost_for_vertex contains minimum cost for each vertex from source;
        //costly roads;
        long tot=0;
        for(int i =0;i<edgefor_vertex.length;i++){
           // System.out.println(i+" "+edgefor_vertex[i]);
            tot+=(long)edgefor_vertex[i];
        }
        return tot;
    }
	public static void main(String[] args) throws IOException{
		Reader r = new Reader();
		Reader.init(System.in);
		int t = r.nextInt();
        for(int o=0;o<t;o++){
            int n = r.nextInt();
            int e = r.nextInt();
            ArrayList<Integer>[] graph = new ArrayList[n];
            for(int i=0;i<n;i++){
                graph[i] = new ArrayList<Integer>();
            }
            long[][] cost = new long[n][n];
            long total=0;
            for(int k=0;k<e;k++){
                int i = r.nextInt()-1;
                int j = r.nextInt()-1;
                long c = r.nextLong();
                graph[i].add(j);
                graph[j].add(i);
                cost[i][j]=c;
                cost[j][i]=c;
                total+=c;
            }
            System.out.println(total-solve(graph,cost,0));
            
        }
	}
}




