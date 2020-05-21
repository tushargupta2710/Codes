import java.util.*;
import java.math.*;
import java.*;
//recursive dfs
class node{
	int val;
	node next;
	node prev;
	node(int v){
		val = v;
		next=null;
		prev=null;
	}
}
public class doublelinkedlist{
	static node head;
	static node tail;
	static int size;
	linkedlist(int s){
		size=s;
		head=null;
		tail=null;
	}

	static void addnode(int val){
		node v = new node(val);
		if(head==null){
			head=v;
			tail=v;
		}
		else{
			node x= tail;
			tail=v;
			tail.prev= x;
			x.next=v;
		}
		size++;
	}

	static void print(){
		node x = head;
		for(int i=0;i<size;i++){
			System.out.println(x.val);
			x=x.next;
		}
	}
	static void delete(int x){
		node temp = head;
		if(temp.val==x){
			head=temp.next;
			head.prev=null;
			size--;
			System.out.println("delete "+size);
		}
		
		else{
			temp=temp.next;
			int i=1;
			for(i=1;i<size-1;i++){
				if(temp.val==x){
					node pr = temp.prev;
					node ne = temp.next;
					pr.next=ne;
					ne.prev = pr;
					System.out.println("delete "+temp.val);
					break;
				}
				temp=temp.next;
			}
			if(temp.val==x && i == size-1){
					node pr = temp.prev;
					pr.next=null;
					tail=pr;
				}
			size--;

		} 
	}
	static void addafter(int x , int y){
		node temp=head;
		node daal = new node(y);

		for(int i=0;i<size;i++){
			if(temp.val==x){
				node a = temp.next;
				temp.next= daal;
				daal.prev = temp;
				daal.next = a;
				size++;
				if(i==size){
					tail=daal;
				}
				break;
			}
			temp = temp.next;

		}
	}


	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s= sc.nextInt();
		doublelinkedlist l = new doublelinkedlist(0);
		for(int k=0;k<s;k++){
			l.addnode(sc.nextInt());	
		}
		l.print();
		//l.delete(1);
		//l.addafter(4,6);
		//l.print();


		

	}
}





			







