import java.util.*;
import java.io.*;
import java.math.*;

public class disjointset{
	static int[] parent;
	static int[] rank;
	static int[] arr;
	static HashMap<Integer,Integer> map = new HashMap<>();
	static void makeset(){
		for(int i=0;i<arr.length;i++){
			parent[i] = i;
			rank[i] =0;
		}
	}
	static int find(int index){
		if(index==parent[index])
			return index;
		else
			parent[index] = find(parent[index]);
		return parent[index];
	}
	static boolean union(int i,int j){
		int parent_i = find(i);
		int parent_j = find(j);
		if(parent_i==parent_j)
			return true;
		else if(rank[parent_i]==rank[parent_j]){
			parent[parent_j] = parent[parent_i];
			rank[parent_i]++;
		}
		else if(rank[parent_i]<rank[parent_j])
			parent[parent_i]=parent[parent_j];
		else
			parent[parent_j] = parent[parent_i];
		return false;
	}


	public static void main(String[] args) throws IOException{
		Reader r = new Reader();
        Reader.init(System.in);
		int n = r.nextInt();
		arr = new int[n];
		parent = new int[n];
		rank = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = r.nextInt();
			map.put(arr[i],i);
		}
		makeset();
		int q = r.nextInt();
		for(int i=0;i<q;i++){
			union(map.get(r.nextInt()),map.get(r.nextInt()));
		}
		for(int i=0;i<parent.length;i++){
			System.out.println(parent[i]);
		}
			


	}
}



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
    int a;
    int b;// cost to rreach\
    int dif =0;
    node(int v,int va){
        a=v;
        b=va;
        dif = Math.abs(b) - Math.abs(a);
    }
}







// implementation using node class
// public class disjointset{
// 	static HashMap<Integer,node> map = new HashMap<>();
// 	static class node{
// 		int data;
// 		int rank;
// 		node parent;
// 		node(int d,int r){
// 			data = d;
// 			rank = r;
// 			parent = null;
// 		}
// 	}

// 	static node makeset(int d){
// 		node n = new node(d,0);
// 		n.parent =n;
// 		map.put(d,n);
// 		return n;
// 	}
// 	static node getparent(node x){
// 		if(x==x.parent)
// 			return x;
// 		else
// 			x.parent =  getparent(x.parent);
// 		return x.parent;
// 	}

// 	static void union(int ai, int bi){
//         node a = map.get(ai);
//         node b = map.get(bi);
// 		node a_parent = getparent(a);
// 		node b_parent = getparent(b);
// 		if(a_parent==b_parent)
// 			return;
// 		else if(a_parent.rank==b_parent.rank){
// 			a_parent.parent = b_parent;
// 			b_parent.rank++;
// 		}
// 		else if(a_parent.rank>b_parent.rank){
// 			b_parent.parent = a_parent;
// 		}
// 		else
// 			a_parent.parent = b_parent;
// 		return;			
// 	}
// 	// it is important to update all nodes.
// 	static void update(){
// 		for(int i:map.keySet()){
//             getparent(map.get(i));
//         }
// 	}

// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		node[] array = new node[5];
// 		for(int i=0;i<5;i++){
// 			array[i]= makeset(i);
// 		}
		
// 	}
// }












