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
    char c;
    node left;
    node right;
    node(char ca,int v){
        c=ca;
        val=v;
        left=null;
        right=null;
    }
}
public class huffman_coding{
    static node root;
    static String[] arrayans = new String[26];
    static int firstindex;
    static int secondindex;
    huffman_coding(){
        root=null;
    }
    static void findfirst_and_second(node[] char_and_value,boolean[] ischecked){
        firstindex=-1;
        secondindex=-1;
        int first =Integer.MIN_VALUE;
        int second =Integer.MIN_VALUE;
        ischecked[26]=false;
        for(int i=0;i<27;i++){
            if(!ischecked[i] && char_and_value[i]!=null){
                if(char_and_value[i].val>=first){
                    int a = firstindex;
                    int av = first;
                    first=char_and_value[i].val;
                    firstindex = i;
                    second = av;
                    secondindex = a;
                }
                else if(char_and_value[i].val>=second){
                    second  = char_and_value[i].val;
                    secondindex = i;
                }
            }
        }
    }

    static void make_huff(node[] char_and_value,boolean[] ischecked,int count ){
        
        while(count>0 ){
            findfirst_and_second(char_and_value,ischecked);
            //System.out.println(firstindex+" "+secondindex);
            node one = char_and_value[firstindex];
            node two = char_and_value[secondindex];
            //node n = new node('A',char_and_value[firstindex].val+char_and_value[secondindex].val);
            node x = new node('~',char_and_value[firstindex].val+char_and_value[secondindex].val);
            char_and_value[26] = x;
            if(char_and_value[firstindex].c!='~' && char_and_value[secondindex].c!='~' ){
                count-=2;
                char_and_value[26] = x  ;
            }
            else
                count--;
            
            if(char_and_value[firstindex].c!='~')
                ischecked[firstindex] = true;
            if(char_and_value[secondindex].c!='~')
                ischecked[secondindex] = true;

            x.left = two;
            x.right = one;
            root = x;
            
        }
    }

    static void print_huff(node root,String ans){
        if(root!=null){
            if(root.left!=null){
                print_huff(root.left,ans+"0");
                print_huff(root.right,ans+"1");
            }
            else{
                Character ch = root.c;
                //System.out.print(ch);
                System.out.println(Character.toString(ch)+": "+ans);
            }
        }
    }

    static void solve(node root,String s){
        String ans = "";
        for(int i=0;i<s.length();i++){
            node temp=root;
            while(temp!=null){
                if(temp.left==null){
                    char daal = temp.c;
                    ans=ans.concat(Character.toString(daal));
                    i--;
                    break;
                }
                char x = s.charAt(i);
                if(x=='0'){
                    temp = temp.left;
                    i++;
                }
                else {
                    i++;
                    temp = temp.right;
                }
                
            }
        }
        System.out.println(ans);
    }

    static int findindex(char[] chararr,Character x){
        for(int i=0;i<chararr.length;i++){
            if(chararr[i]==x)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        Reader.init(System.in);
        int k =r.nextInt();
        for(int o=0;o<k;o++){
            int t = r.nextInt();
            int[] value = new int[26+1];
            
            boolean[] ischecked = new boolean[26+1];// because a will always be false;
            
            node[] char_and_value = new node[27];
            char[] chararr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'
                                ,'q','r','s','t','u','v','w','x','y','z','A'};
            ischecked[26]=false;
            String s="";


            for(int i=0;i<t;i++){
                s = r.next();
                int v = r.nextInt();
                int index = findindex(chararr,s.charAt(0));
                char_and_value[index] = new node(s.charAt(0),v);
            }
            for(int i=0;i<26;i++){
                if(char_and_value[i]==null){
                    ischecked[i]=true;
                }
            }

            huffman_coding huff = new huffman_coding();
            String str = r.next();
            if(t==1){
                //System.out.println(t);
                for(int i=0;i<str.length();i++){
                    System.out.print(s.charAt(0));
                }
            }
            else{
                huff.make_huff( char_and_value, ischecked ,t);
                huff.solve(huff.root,str);
            }

                
            
    }
}
}








