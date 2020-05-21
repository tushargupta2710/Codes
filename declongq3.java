import java.util.*;

class declongq3{

	static void sub(String s,int dp[], int l){
		for(int i=l-1;i>-1;i--){
			int count=0;
			for(int j=i-1;j>-1;j--){
				if(s.charAt(i)==s.charAt(j) && count==0){
					count++;
					dp[i]=j+1;
				}
			}
		}
	}

	static int maxi(int dp[], int l){
		int base=0;
		for(int i=0;i<l;i++){
			//System.out.println(dp[i]);
			if(dp[i]>base)
				base=dp[i];
		}
		return base;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int i=0;i<T;i++){
		int l = sc.nextInt();
		String s = sc.next();

		int[] dp = new int[l];
		
		sub(s,dp,l);
		System.out.println(maxi(dp,l));
		}
	}
}