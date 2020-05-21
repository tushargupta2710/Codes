import java.util.*;
import java.io.*;

// using inbuilt minheap
public class dikstra {
    
    static void solve(ArrayList<Integer>[] graph,int[][] cost,int source){   

        //PriorityQueue<node> pq = new PriorityQueue<node>((a,b)->a.val-b.val);
        minheap pq = new minheap(1000000);
        //distance from source
        int[] distance_from_source = new int[graph.length];
        Arrays.fill(distance_from_source,Integer.MAX_VALUE);
        distance_from_source[source]=0;
        node no  = new node(source,0);
        pq.insert(no);
  
        //Set<Integer> set = new HashSet<>();
        boolean[] set = new boolean[1000000];
        int count=0;
        while(count<graph.length && pq.size>0){
            
            node m = pq.extractmin();
        if(!set[m.vert] ){
            //System.out.println(m.vert);
            int min_index= m.vert;
            //set.add(min_index);
            set[min_index]=true;
            count++;
            if(graph[min_index].size()!=0){
                for(int i=0;i<graph[min_index].size();i++){
                    int x = min_index;
                    int y = graph[min_index].get(i);
                    //System.out.println(x+" "+y);
                    if(distance_from_source[x]!=Integer.MAX_VALUE && distance_from_source[x]+cost[x][y]<distance_from_source[y]){
                        distance_from_source[y] = distance_from_source[x]+cost[x][y];
                        pq.insert(new node(y,distance_from_source[y]));
                    }
                }
            }
        }
        }
        // finally distance_from_source contains minimum cost for each vertex from source;
        //costly roads;
        for(int i =0;i<distance_from_source.length;i++){

             if(i!=source && distance_from_source[i]!=Integer.MAX_VALUE)
                System.out.print(distance_from_source[i]+" ");
            else if(i!=source)
                System.out.print(-1+" ");
        }
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
            int[][] cost = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
            for(int k=0;k<e;k++){
                int i = r.nextInt();
                int j = r.nextInt();
                int c = r.nextInt();
                graph[i].add(j);
                graph[j].add(i);
                if(cost[i][j]>c)
                    cost[i][j]=c;
                if(cost[j][i]>c)
                    cost[j][i]=c;
            }
            
            int s = r.nextInt();
            solve(graph,cost,s);
            System.out.println();
        }
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

class minheap{
    static node[] array;
    static int size;
    minheap(int capacity){
        array = new node[capacity];
        size=0;
       // Arrays.fill(array,Math.MIN_VALE);
    }
    static int parent(int i){
        return (i-1)/2;
    }
    static int leftchild(int i){
        return 2*i +1;
    }
    static int rightchild(int i){
        return 2*i +2;
    }
    static node minimum(){
        return array[0];
    }

    static void insert(node val){
        array[size] = val;
        makeheap_bootom_to_up(size);
        size++;
    }
    static void makeheap_bootom_to_up(int i){
        int pr = parent(i);
        if(pr>=0 && array[pr].val>array[i].val ){
            node x = array[i];
            array[i] = array[pr];
            array[pr] = x;
            makeheap_bootom_to_up(pr);
        } 
    }
    static void printall(){
        for(int i=0;i<size;i++)
            System.out.print(array[i].vert+" ");
    }
    static node extractmin(){ // initial input will be root; i.e; 0
        node ans = array[0];
        array[0] = array[size-1];
        //array[size-1] = 0.0;
        size=size-1;
        makeheap_up_to_bootom(0);
        return ans;
    }
    static void makeheap_up_to_bootom(int i){

        int l = leftchild(i);
        int r = rightchild(i);
        // is a leaf;
        if(i>=size/2) 
            return;
        // only 1 child, left
        if(r>=size){
            if(array[i].val>array[l].val){
                node x = array[i];
                array[i] = array[l];
                array[l] = x;
                makeheap_up_to_bootom(l);
            }
            else
                return;
        }
        if(i<size && (array[i].val>array[l].val | array[i].val>array[r].val)){
            if(array[l].val<=array[r].val){
                node x = array[i];
                array[i] = array[l];
                array[l] = x;
                makeheap_up_to_bootom(l);
            }
            else{
                node x = array[i];
                array[i] = array[r];
                array[r] = x;
                makeheap_up_to_bootom(r);
            }
        }
    }

    
}

