import java.util.*;
import java.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
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
	int val;
	node left;
	node right;
	node(int v){
		val=v;
		left=null;
		right=null;
	}
}
public class bst{
	static node root;
	bst(){
		root=null;
	}
	
	static boolean search( node root ,int v){
		if(root==null)
			return false;
		if(root.val == v)
			return true;
		else if(root.val>v)
			return search(root.left,v);
		else
			return search(root.right,v);
	}

	static void insertIntoBST( int val) {
        root = insert(root,val);
    }

    static node insert(node root,int val){
        if(root == null)
            return new node(val);
        else if(root.val>val)
            root.left = insert(root.left,val);
        else
            root.right = insert(root.right,val);
        return root;
    }

    static void del(int v){
    	root = delete(root,v);
    }
    static  node delete(node root,int v){
    	//if node is found
    	if(root.val==v){
    		// 0 child
    		if(root.left==null && root.right==null)
    			return null;
    		//1 child
    		else if(root.left==null)
    			return root.right;
    		else if(root.right==null)
    			return root.left;

    		// 2 child
    		else{
    			int x = min(root.right);
    			delete(root,x);
    			root.val = x;
    			System.out.println("deleted "+x);
    		}
    	}
    	else if(root.val>v){
    		root.left = delete(root.left,v);
    	}
    	else{
    		root.right = delete(root.right,v);
    	}
    	return root;
    }
    static int min(node root){
    	int x = root.val;
    	while(root.left!=null){
    		x = root.left.val;
    		root=root.left;
    	}
    	return x;
    }

    static void inorder(node root){
    	if(root!=null){
    		inorder(root.left);
    		System.out.println(root.val);
    		inorder(root.right);
    	}
    }
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int n = Reader.nextInt();
		bst tree = new bst();
		for(int i=0;i<n;i++){
			String a = Reader.next();
			String[] arr = a.split(" ")
			if(a.equals("INSERT")){
				System.out.println(a);
				int x = Reader.nextInt();
				System.out.println(x);
				tree.insertIntoBST(x);
			}
			if(a.equals("COUNT")){
				int x = Reader.nextInt();
			}
			if(a.equals("FIND")){
				int x = Reader.nextInt();
			}
			if(a.equals("DELETE")){
				int x = Reader.nextInt();
				tree.del(x);
			}
			tree.inorder(root);
		}
		

	}
}