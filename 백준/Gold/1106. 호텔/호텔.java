import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[100001];
        for (int i = 0; i < 100001; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - arr[j][0] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - arr[j][0]] + arr[j][1]);
                }
            }
        }
        for (int i = 1; i <= 100001; i++) {
            if (dp[i] >= c) {
                System.out.println(i);
                break;
            }
        }
    }
}