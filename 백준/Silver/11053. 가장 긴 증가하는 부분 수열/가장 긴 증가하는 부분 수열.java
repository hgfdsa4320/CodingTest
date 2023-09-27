import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr =new int[n];
		int[] dp = new int[n];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0]=1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				dp[i] = Math.max(dp[i], arr[i]>arr[j]?dp[j]+1:1);	
			}
		}
		int answer = 0;
		for(int i=0;i<n;i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}