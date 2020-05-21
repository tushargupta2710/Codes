import java.util.*;
import java.io.*;
 

public class kruskels {
    
    static int[][] weight;
    static int[][] edges;
    static int[] edge_for_vertex;
    static int[] parent;
    static int[] rank;


    static void makeset(){
        for(int i=0;i<parent.length;i++)
            parent[i]=i;
    }
    static int find(int i){
        if(i == parent[i])
            return i;
        else{
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    static boolean union(int a , int b){

        int parent_a = find(a);
        int parent_b = find(b);
        //System.out.println(parent_a+" "+parent_b);
        if(parent_a==parent_b)
            return true;
        else if(rank[parent_a] == rank[parent_b] ){
            parent[parent_a] = parent_b;
            rank[parent_b]++;
        }
        else if(rank[parent_a]<rank[parent_b]){
            parent[parent_a] = parent_b;
        }
        else
            parent[parent_b] = parent_a;
        return false;
    }







    public static void main(String[] args) throws IOException{
        Reader r = new Reader();
        Reader.init(System.in);
        int v = r.nextInt();
        int e = r.nextInt();
        edges = new int[v+1][2];
        weight = new int[v+1][v+1];
        edge_for_vertex = new int[v];
        //assuming 0 indexing
        for(int i=0;i<e;i++){
            int a = r.nextInt();
            int b = r.nextInt();
            edges[i][0] = a; edges[i][1] = b;
            weight[a][b] =  r.nextInt();
        }
        parent = new int[v];
        rank = new int[v];
        mergesort.sort(0,v-1,edges,weight);
        makeset();
        for(int i=1;i<v;i++){
            edge_for_vertex[i]=-1;
        }
        edge_for_vertex[0] = 0;
        int sum=0;
        for(int i=0;i<e;i++){
            int[] ed = edges[i];
            int a = ed[0];
            int b = ed[1];
            if(!union(a,b)){
                edge_for_vertex[b] = weight[a][b];  
                System.out.println(weight[a][b]);
                sum+=weight[a][b];
            }
        }
        System.out.println(sum);
        
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
    int val;// cost to rreach\
    node(int s,int va){
        a=s;
        val=va;
    }
}
class mergesort{
    static void sort(int l, int h, int[][] arr,int[][] weight){
        if(l<h){
            int mid = (l+h)/2;
            
            sort(l,mid,arr,weight);
            sort(mid+1,h,arr,weight);
            merge(l,mid,h,arr,weight);
        }
    }
    static void merge(int l, int m , int h , int [][] arr,int[][] weight){
 
        int[][] left = new int[m-l+1][2];
        int[][] right = new int[h-m][2];
        for(int i= 0 ;i< m-l+1;i++){
            left[i] = arr[l+i];
        }
        for(int i=0;i<h-m;i++){
            right[i] = arr[m+1+i];
        }
        //now left and right arrays are assumed to be sorted and we have tp merge them together 
        // int the original aaray.
        int i=l;
        int lindex = 0;
        int rindex =  0;
        
        while(lindex<m-l+1 && rindex<h-m){
            if(weight[left[lindex][0]][left[lindex][1]]<=weight[right[rindex][0]][right[rindex][1]]){
                arr[i]=left[lindex];
                lindex++;
                i++;
            }
            else{
                arr[i]=right[rindex];
                rindex++;
                i++;
            }
        }
        while(lindex<m-l+1){
            arr[i]=left[lindex];
            lindex++;
            i++;
        }
        while(rindex<h-m){
            arr[i]=right[rindex];
            rindex++;
            i++;
        }
    }
    
}
 