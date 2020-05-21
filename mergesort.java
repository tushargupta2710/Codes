import java.util.*;
import java.*;
import java.io.*;
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
class node{
	int n;
	int ind;
	node(int val, int in){
		n=val;
		ind=in;
	}
}
public class mergesort{
	static void sort(int l, int h, long[] arr){
		if(l<h){
			int mid = (l+h)/2;
			
			sort(l,mid,arr);
			sort(mid+1,h,arr);
			merge(l,mid,h,arr);
		}
	}
	static void merge(int l, int m , int h , long [] arr){

		long[] left = new long[m-l+1];
		long[] right = new long[h-m];
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
	

	public static void main(String[] args) throws IOException{
		Reader r = new Reader();
      	Reader.init(System.in);
		int t = r.nextInt();
		for(int w=0;w<t;w++){
			int n = r.nextInt();
			int k = r.nextInt();
			long[] arr = new long[n];
			long[] prefixsum = new long[n+1];
			for(int i=0;i<n;i++){
				arr[i] = r.nextLong();
			}
			sort(0,n-1,arr);
			long prev = 0;
			for(int i=0;i<n;i++){
				prefixsum[i] = prev+arr[i];
				prev = prefixsum[i];
			}
			int start = 0;
			int end = n-1;
			PriorityQueue<Long> pq = new PriorityQueue<Long>((a,b)->b-a);
			for(int i=1;i<=k;i++){
				int count=0;
				while(start<end){
					pq.add(prefixsum[end]-prefixsum[start]) ; 
					start++;
					count++;
				}
				i+=count;
				start=0;
				end = end-1;
			}
			for(int i=0;i<k;i++ ){
				System.out.print(pq.poll()+" ");
			}
		}

}
}








