import java.util.*;
import java.io.*;

/** Class for buffered reading int and double values */
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
// Java program to implement Max Heap 


public class maxheap{
    
    static double[] Heap; 
    static int size; 
    static int maxsize; 

    // Constructor to initialize an 
    // empty max heap with given maximum 
    // capacity. 
    public maxheap(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new double[this.maxsize + 1]; 
        Heap[0] = Double.MAX_VALUE; 
    } 

    // Returns position of parent 
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 

    // Below two functions return left and 
    // right children. 
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 

    // Returns true of given node is leaf 
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 

    private void swap(int fpos, int spos) 
    { 
        double tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 

    // A recursive function to max heapify the given 
    // subtree. This function assumes that the left and 
    // right subtrees are already heapified, we only need 
    // to fix the root. 
    private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 

        if (Heap[pos] < Heap[leftChild(pos)] || 
            Heap[pos] < Heap[rightChild(pos)]) { 

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 

    // Inserts a new element to max heap 
    public void insert(double element) 
    { 
        Heap[++size] = element; 

        // Traverse up and fix violated property 
        int current = size; 
        while (Heap[current] > Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 

    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
                    Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 

    // Remove an element from max heap 
    public double extractMax() 
    { 
        double popped = Heap[1]; 
        Heap[1] = Heap[size];
        Heap[size-1] = Double.MIN_VALUE; 
        maxHeapify(1); 
        return popped; 
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
        double res = (double)10000000;
        double sum = 0;

        maxheap pq = new maxheap(10000000);
       // PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] det: detective) {
            sum += det[1];
            pq.insert(-det[1]);
            if (pq.size > k) {
                sum += pq.extractMax();
            }
            if (pq.size == k){
                res = Math.min(res, sum * det[0]);
            }
        }
        System.out.println((int)Math.ceil(res));
      
    }
}








