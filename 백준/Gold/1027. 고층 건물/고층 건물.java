import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int now = 0; now < n; now++) {
            int cnt = 0;
            int left = now - 1;
            double leftMax = Integer.MIN_VALUE;
            int right = now + 1;
            double rightMax = Integer.MIN_VALUE;
            for (int i = left; i >= 0; i--) {
                double incline = (double)(arr[i]-arr[now])/(now-i);
                if (incline > leftMax) {
                    cnt++;
                    leftMax = incline;
                }
            }
            for (int i = right; i < n; i++) {
                double incline = (double)(arr[i]-arr[now])/(i-now);
                if (incline > rightMax) {
                    cnt++;
                    rightMax = incline;
                }

            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}