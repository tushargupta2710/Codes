import java.util.*;
import java.math.*;
//Bubble Sort is the simplest sorting algorithm that works by repeatedly 
//swapping the adjacent elements if they are in wrong order.

//selection sort is reverse of bubble sort.
public class bubblesort{


	static void sort(int array[],int s,int end){
		int var=end;
		for(int k=s;k<end;k++){
			for(int i=s;i<var-1;i++){
				if(array[i]>array[i+1]){
					int x = array[i];
					array[i]=array[i+1];
					array[i+1]=x;
				}
			}
			var--;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] array = new int[t];
		for(int i=0;i<t;i++){
			array[i]=sc.nextInt();
		}
		sort(array,0,t);
		for(int i=0;i<t;i++){
			System.out.println(array[i]);
		}

		
	}
}