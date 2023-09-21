import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1][2] = arr[1];
        dp[1][2] = arr[1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 2][1], dp[i - 2][2]), dp[i - 2][3]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[i];
            dp[i][3] = dp[i - 1][2] + arr[i];
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[n][i]);
        }
        System.out.println(answer);
    }
}