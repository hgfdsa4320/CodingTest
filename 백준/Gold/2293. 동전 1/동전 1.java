import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		int[] dp = new int[100001];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0;i<n;i++) {
			dp[coins[i]]+=1;
			for(int j=1;j<=k;j++) {
				if(j-coins[i]>0 && dp[j-coins[i]]!=0) {
					dp[j]+=dp[j-coins[i]];
				}
			}
		}
		System.out.println(dp[k]);
	}
}