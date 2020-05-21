import java.util.*;
import java.math.*;
import java.*;
//recursive dfs
class node{
	int val;
	node next;
	node(int v){
		val = v;
		next=null;
	}
}
public class circular_linkedlist{
	static node rear;
	static node cur;
	circular_linkedlist(){
		rear=null;
		cur=null;
	}
	static void addnodeaftercur(int x){
		node n = new node(x);
		if(rear==null){
			rear=n;
			rear.next=rear;
			cur=rear;
		}
		else if(cur==rear){
			node a = rear.next;
			cur.next=n;
			n.next=a;
			rear=n;
		}
		else{
			node a = cur.next;
			cur.next = n;
			n.next = a;
		}
	}
	static void printcur(){
		System.out.println(cur.val);
	}
	static void inc(){
		cur=cur.next;
	}

	static void add(int x){
		node temp = rear;
		node n = new node(x);
		if(rear== null){
			rear = n;
			rear.next = rear;
		}
		else{
			node ne = rear.next;
			rear.next = n;
			n.next = ne;
			rear = n;
		}
	}

	static void printall(){
		node temp = rear.next;
		while(temp!=rear){
			System.out.print(temp.val + " ");
			temp=temp.next;
		}
		System.out.print(temp.val);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s= sc.nextInt();
		circular_linkedlist c  = new circular_linkedlist();
		
		for(int i=0;i<s;i++){
			int a = sc.nextInt();
			c.add(a);
		}
		c.printall();


		

	}
}





			







