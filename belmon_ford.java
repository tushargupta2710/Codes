import java.util.*;
import java.io.*;
 

public class belmon_ford {
    //static ArrayList<Integer>[] graph ;
    static long[][] arr; // 0th index stores dkstance for ith vertex, and 1th index stores parent.
    static boolean negcycle = false;;
    static int[][] edges;
    static long[][] weight;
    
    static void solve(int s, int v, int e ){
        // V relaxes , v-1 for shortest path and vth for neg cycle check.
        for(int k=0;k<v;k++){
            // for each edge
            for(int i=0;i<e;i++){

                int a = edges[i][0];
                int b = edges[i][1];
                if(arr[b][0] > arr[a][0]+weight[a][b]){
                    if(k==v-1)
                        negcycle = true;
                    arr[b][0] = arr[a][0]+weight[a][b];
                    arr[b][1] = (long)a; // parent
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        Reader r = new Reader();
        Reader.init(System.in);
        int v = r.nextInt();
        int e = r.nextInt();
        int s = r.nextInt();
        edges = new int[e+1][2];
        weight = new long[v+1][v+1];
        for(int i=0;i<e;i++){
            int a = r.nextInt();
            int b = r.nextInt();
            weight[a][b] = r.nextLong();
            weight[b][a] = weight[a][b];
            edges[i][0] = a; 
            edges[i][1] = b;
        }
        arr = new long[v+1][2];
        for(int i=0;i<v;i++){
            arr[i][0] = 1000000000;
        }
        arr[s][0] = (long)0;
        negcycle = false;
        solve(s,v,e);
        
        // acc. to output
        if(negcycle)
            System.out.println(-1);
        else{
            for(int i=0;i<v;i++){
                System.out.println(i+" "+arr[i][0]);
            }
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



