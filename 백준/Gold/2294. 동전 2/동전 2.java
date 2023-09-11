import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		int[] dp = new int[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i=0;i<n;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0;i<n;i++) {
			dp[coins[i]]=1;
			for(int j=1;j<=k;j++) {
				if(j-coins[i]>0 && dp[j-coins[i]]!=Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j-coins[i]]+1); 
				}
			}
		}
		if(dp[k]==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[k]);
	}
}