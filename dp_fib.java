#TBULATION METHOD
# BOTTOM UP WHERE BOTTOM IS THE BASE CASE.
import java.util.*;

class dp_fib{
	static int[] memory = new int[100] ;
	static void fib(int num){
		memory[0]=0;
		memory[1]=1;
		for(int i=2;i<num;i++){
			memory[i]= memory[i-1]+memory[i-2];		
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		fib(a);
		System.out.println(memory[a-1]);
	}
}