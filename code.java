
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//import java.util.Stack;
class Node{
            int data;
            Node next;
            Node(int d){
                data = d;
                next = null;
            }
}
class Stack{
            static Node top;
            static int size;
            public Stack() {
                top = null;
                size = 0;
        }

        public static boolean IsEmpty() {
            return top == null;
        }
        public static int size(){
            return size;
        }
        public static void pop() {
            if(top==null) {
                return;
            }else {
                Node s = top;
                top = top.next;
                s = null;
                size--;
            }
        }
        public static void push(int x) {
            Node s = new Node(x);
            if(top==null) {
                top=s;
                size++;
            }else {
            top.next=s;
            top = s;
            size++;}
            }
        public static int peek() {
            if( top==null) {
                return -1;
            }
            else {
                return top.data;
            }
        }
}

public class code {
     
    

        public static void main(String args[]) throws IOException{
            Reader.init(System.in);
            String s = Reader.next();
            int n = s.length();
       
        Stack stack = new Stack();
        for(int i=0;i<n;i++){
            if(stack.size==0)
                stack.push(s.charAt(i));
            else if(stack.peek()==s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        
        if (stack.size()==0)
            System.out.println("Yes");
        else
            System.out.println("Yes");
    }
    
}



       
   
        


   

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }

    public String nextLine() throws IOException {
        return reader.readLine();
    }
}
