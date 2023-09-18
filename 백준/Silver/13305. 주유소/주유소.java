import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dis = new int[n];
		for(int i=1;i<n;i++) {
			dis[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] price = new int[n+1];
		for(int i=1;i<=n;i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[100001][2];
		dp[0][0] = Integer.MAX_VALUE;
		
		for(int i=1;i<n;i++) {
			dp[i][0] = Math.min(dp[i-1][0], price[i]);
			dp[i][1] = dp[i-1][1]+dp[i][0]*dis[i];
		}
		System.out.println(dp[n-1][1]);
	}
}