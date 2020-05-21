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
	doublelinkedlist(int s){
		size=s;
		head=null;
		tail=null;
	}
//////////////////////////////////////////////////////////////////////////////////////////
	static void addnode_in_end(int val){
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
//////////////////////////////////////////////////////////////////////////////////////////
	static void print(){
		node x = head;
		for(int i=0;i<size;i++){
			System.out.print(x.val+" ");
			x=x.next;
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////


	static void delete_node(int x){
		node temp = head;
		if(temp.val==x){
			head=temp.next;
			head.prev=null;
			//
			if(tail==temp)
				tail= head;
			//
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
////////////////////////////////////////////////////////////////////////////////////////////////////////

	static void add_after_node(int x , int y){
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

////////////////////////////////////////////////////////////////////////////////////////////////////////
	static void addnode_atpos(int p,int v){
		node temp= head;
		node n = new node(v);
		if(head==null){
			head=n;
			tail=n;
			size++;
		}
		else{
			if(p==1){
				head = n;
				head.next = temp;
				temp.prev = head;
				if(size==1)
					tail=head;	
				size++;
			}
			else {
				int i=0;
				int count=0;
				for(i=0;i<size-1;i++){
					if(i==p-2){
						node nex = temp.next;
						temp.next = n;
						n.prev = temp;
						n.next = nex;
						nex.prev = n;
						size++;
						count=1;
						break;
					}
					temp=temp.next;
				}
				if(i == p-1 && count==0){
					temp.next = n;
					n.prev = temp;
					tail=n;
					size++;
				}
			}
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////
static void delete_atpos(int p ){
	node temp = head;
	if(p==1){
		head = temp.next;
		head.prev = null;
		if(size==1)
			tail=head;
		size--;
	}
	else{
		int i=0;
		for(i=0;i<size-1;i++){
			if(i==p-1){
				node nex = temp.next;
				node pr = temp.prev;
				pr.next = nex;
				nex.prev = pr;
				size--;
				break;
			}
			temp=temp.next;
		}
		if(i==p-1){
			node pr = temp.prev;
			pr.next = null;
			tail = pr;
			size--;
		}
	}
}



////////////////////////////////////////////////////////////////////////////////////////////////////////




	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		doublelinkedlist g  = new doublelinkedlist(0);
		for(int i = 0;i<Q;i++){
			int q = sc.nextInt();
			if(q==1){
				int p = sc.nextInt();
				int x = sc.nextInt();
				g.addnode_atpos(p,x);
			}
			else if(q==2){
				int p = sc.nextInt();
				g.delete_atpos(p);

			}
			else{
				g.print();
				System.out.println();
			}
		}

	}
}





			







