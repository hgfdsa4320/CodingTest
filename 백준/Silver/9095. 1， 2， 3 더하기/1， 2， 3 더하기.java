import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=0;tc<t;tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[11];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for(int i=4;i<=10;i++) {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			System.out.println(dp[n]);
		}
	}
}