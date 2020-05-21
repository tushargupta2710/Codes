import java.util.*;
import java.io.*;
 

  class gfg {
    
    static long[][] cost;
    static ArrayList<Integer>[] graph;
    static boolean[] supply;
    static long[] mincost;
    static int e=0;
    static boolean reached = false;
    static int[][] edges;
    static boolean[] vis;
    static long min  = Long.MAX_VALUE;



    static void solve(String[] arr,int cur,int cur_length, int l,String str){
        if(cur_length<=l && cur<arr.length){
            if(cur_length==l)
                System.out.println(str);
            solve(arr,cur+1,cur_length+1,l,str=str+arr[cur_length]);
            solve(arr,cur+1,cur_length+1,l,str);
        }
    }



    public static void main(String[] args) throws IOException{
        Reader r = new Reader();
        Reader.init(System.in);
        String[] arr = new String[6];
        for(int i=0;i<6;i++){
            arr[i] = r.next();
        }
        solve(arr,0,0,4,"");
        
    }

 
    
    

   
    // greatest common divisor
    static int gcd(int a , int b){
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }

    // least common multiple
    static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
    
    // a^b
    static long fastpow(long a, long n){
        //System.out.println("ssdf");
        if(n>0){
            long half = fastpow(a,n/2);
            if(n%2==0){
                return half*half;
            } 
            else
                return a*half*half;
        }
        return 1;
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
class newcomparator implements Comparator<Integer>{
    //@Override
    public int compare(Integer a, Integer  b){
        return a<=b?1:-1;
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
    static void sort(int l, int h, int[] arr){
        if(l<h){
            int mid = (l+h)/2;
            
            sort(l,mid,arr);
            sort(mid+1,h,arr);
            merge(l,mid,h,arr);
        }
    }
    static void merge(int l, int m , int h , int [] arr){
 
        int[] left = new int[m-l+1];
        int[] right = new int[h-m];
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
            if(left[lindex]<=right[rindex]){
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
 