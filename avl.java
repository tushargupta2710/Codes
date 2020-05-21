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
class node{
    int val;
    node left;
    node right;
    int height;
    node(int v){
        val=v;
        left=null;
        right=null;
        height =1;
    }
}
public class avl{
    static node root;
    avl(){
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

    static int getheight(node x){
        if(x==null)
            return 0;
        else
            return x.height;
    }
    static int getbalance(node x){
        if(root == null )
            return -5;
        else
            return getheight(root.left) - getheight(root.right);
    }

    static node rotateright(node root){
        node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        temp.height = Math.max( getheight(temp.left)  , getheight(temp.right)) +1;
        root.height = Math.max( getheight(root.left)  , getheight(root.right)) +1;
        return root.left;
    }

    static node rotateleft(node root){
        node temp = root.right;
        root.left = temp.left;
        temp.left = root;
        temp.height = Math.max( getheight(temp.left)  , getheight(temp.right)) +1;
        root.height = Math.max( getheight(root.left)  , getheight(root.right)) +1;
        return root.right;
    }


    static void insertIntoAVL( int val) {
        root = insert(root,val);
    }

    static node insert(node root,int val){
        if(root == null)
            return new node(val);
        else if(root.val>val)
            root.left = insert(root.left,val);
        else
            root.right = insert(root.right,val);

        root.height = Math.max( getheight(root.left)  , getheight(root.right)) +1;
       // System.out.println(root.val+" "+root.height);


        if(getbalance(root) >=2 && getbalance(root.left)==1 )
            return rotateright(root);
        if(getbalance(root) >=2 && getbalance(root.left)==-1){
            root.left = rotateleft(root.left);
            return rotateright(root);
        }
        if(getbalance(root) <=-2 && getbalance(root.right)==-1 )
            return rotateleft(root);
        if(getbalance(root) <=-2 && getbalance(root.right)==1){
            root.right = rotateright(root.right);
            return rotateleft(root);
        }

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
               // System.out.println("deleted "+x);
            }
        }
        else if(root.val>v){
            root.left = delete(root.left,v);
        }
        else{
            root.right = delete(root.right,v);
        }

        if(root==null)
            return root;
        root.height = Math.max( getheight(root.left)  , getheight(root.right)) +1;
        //System.out.println(root.val+" "+root.height);


        if(getbalance(root) ==2 && getbalance(root.left)==1 )
            return rotateright(root);
        if(getbalance(root) ==2 && getbalance(root.left)==-1){
            root.left = rotateleft(root.left);
            return rotateright(root);
        }
        if(getbalance(root) ==-2 && getbalance(root.right)==-1 )
            return rotateleft(root);
        if(getbalance(root) ==-2 && getbalance(root.right)==1){
            root.right = rotateright(root.right);
            return rotateleft(root);
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
            System.out.println(root.val+"  height  "+root.height);
            inorder(root.right);
        }
    }
    static void preorder(node root){
        if(root!=null){
            System.out.println(root.val+"  height  "+root.height);
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        int n = Reader.nextInt();
        avl tree = new avl();
        for(int i=0;i<n;i++){
            tree.insertIntoAVL(Reader.nextInt());
        }
        tree.preorder(root);
        tree.del(Reader.nextInt());
        tree.preorder(root);
        

    }
}