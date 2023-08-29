import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=0;tc<t;tc++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			int[][] dp = new int[a+1][b+1];
			for(int i=1;i<=b;i++) {
				dp[0][i] = i;
			}
			for(int i=1;i<=a;i++) {
				int sum = 0;
				for(int j=1;j<=b;j++) {
					sum+=dp[i-1][j];
					dp[i][j] +=sum;
				}
			}
			System.out.println(dp[a][b]);
		}
		

	}

}