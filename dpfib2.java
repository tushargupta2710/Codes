//MEMORIZATION METHOD , TOP DOWN
import java.util.*;

class dpfib2{

	static int[] memory = new int[100];

	static void f(int memory[]){
		for(int i=0;i<100;i++){
			memory[i]=-1;
		}
		memory[0]=0;
		memory[1]=1;
	}

	static int fib(int num){
		if(memory[num]==-1){
			memory[num] = fib(num-1)+fib(num-2);
		}
		else
			return memory[num];
		return memory[num];

	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		f(memory);
		System.out.println(fib(n-1));
	}
}