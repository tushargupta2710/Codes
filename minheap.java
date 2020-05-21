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
class mergesort{
    static void sort(int l, int h, double[][] arr){
        if(l<h){
            int mid = (l+h)/2;
            
            sort(l,mid,arr);
            sort(mid+1,h,arr);
            merge(l,mid,h,arr);
        }
    }
    static void merge(int l, int m , int h , double[][] arr){

        double[][] left = new double[m-l+1][2];
        double[][] right = new double[h-m][2];
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
            if(left[lindex][0]<=right[rindex][0]){
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

public class minheap{
    static double[] array;
    static int size;
    minheap(int capacity){
        array = new double[capacity];
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
    static double minimum(){
        return array[0];
    }

    static void insert(double val){
        array[size] = val;
        makeheap_bootom_to_up(size);
        size++;
    }
    static void makeheap_bootom_to_up(int i){
        int pr = parent(i);
        if(pr>=0 && array[pr]>array[i] ){
            double x = array[i];
            array[i] = array[pr];
            array[pr] = x;
            makeheap_bootom_to_up(pr);
        } 
    }
    static void printall(){
        for(int i=0;i<size;i++)
            System.out.print(array[i]+" ");
    }
    static double extractmin(){ // initial input will be root; i.e; 0
        double ans = array[0];
        array[0] = array[size-1];
        array[size-1] = 0.0;
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
            if(array[i]>array[l]){
                double x = array[i];
                array[i] = array[l];
                array[l] = x;
                makeheap_up_to_bootom(l);
            }
            else
                return;
        }
        if(i<size && (array[i]>array[l] | array[i]>array[r])){
            if(array[l]<=array[r]){
                double x = array[i];
                array[i] = array[l];
                array[l] = x;
                makeheap_up_to_bootom(l);
            }
            else{
                double x = array[i];
                array[i] = array[r];
                array[r] = x;
                makeheap_up_to_bootom(r);
            }
        }
    }
    static void decrease(int i, int d){
        array[i] -= d;
        makeheap_bootom_to_up(i);
    }

    
    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        Reader.init(System.in);
        int n = r.nextInt();
        int k = r.nextInt();
        int[] q = new int[n];
        int[] w = new int[n];
        for(int i=0;i<n;i++){
            q[i] = r.nextInt();
        }
        for(int i=0;i<n;i++){
            w[i] = r.nextInt();
        }
        double[][] detective = new double[n][2];
        for (int i = 0; i < n; i++){
            detective[i][0] = (double)(w[i]) / q[i];
            detective[i][1] =  (double)q[i];
        }

        mergesort.sort(0,n-1,detective);
        //for(double[] ww  : detective)
            //System.out.println(ww[0]+" "+ww[1]);
        double res = Double.MAX_VALUE;
        double sum = 0;

        minheap pq = new minheap(n+1);
       // PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] det: detective) {
            sum += det[1];
            pq.insert(-det[1]);
            if (pq.size > k) {
                sum += pq.extractmin();
            }
            if (pq.size == k){
                res = Math.min(res, sum * det[0]);
            }
        }
        System.out.println((int)Math.ceil(res));
      
    }
}








