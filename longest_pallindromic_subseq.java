import java.util.*;
import java.math.*;

public class longest_pallindromic_substring{

	static void lps(String s,boolean dp[][],int a,int b){

		for(int i=a;i<b;i++){
			
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String s = sc.next();
		boolean[][] array = new boolean[s.length()][s.length()];
		for(int i=0;i<s.length();i++){
			array[i][i]=true;
		}
		System.out.println(lps(s,array,0,s.length()));

	}
}