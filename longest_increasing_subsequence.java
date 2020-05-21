import java.util.*;

class longest_increasing_subsequence{


	static void dp(int value[],int array[], int s){
		for(int i=0;i<s;i++){
			for(int j=0;j<=i;j++){
				if(array[j]<array[i]){
					int k = value[j]+1;
					if(k>value[i])
						value[i]=k;
				}
			}
		}
	}
	static int max(int value[],int s){
		int maxi=0;
		for(int i=0;i<s;i++){
			if(value[i]>maxi)
				maxi=value[i];
		}
		return maxi;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		int[] value = new int[n];

		for(int i=0;i<n;i++){
			value[i]=1;
			array[i]=sc.nextInt();
		}
		dp(value,array,n);
		System.out.println(max(value,n));
		for(int i =0;i<n;i++){
			System.out.println(value[i]);
		}

	}
}