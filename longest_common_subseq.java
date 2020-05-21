import java.util.*;

class longest_common_subseq{

	static int lcs(String a, String b, int dp[][]){
		for(int i=1;i<b.length()+1;i++){
			for(int j=1;j<a.length()+1;j++){
				if(b.charAt(i-1)==a.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else{
					dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
		return dp[b.length()][a.length()];

 	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int[][] dp = new int[b.length()+1][a.length()+1];
		System.out.println(lcs(a,b,dp));

	}
}