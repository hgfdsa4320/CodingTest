import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            pq.offer(new int[]{i, arr[i]});
        }
        int cnt = 0;
        while (true) {
            if (pq.peek()[0] == 0 || arr[0] + cnt > pq.peek()[1]) {
                break;
            }
            int idx = pq.peek()[0];
            int value = pq.poll()[1];
            pq.offer(new int[]{idx, value - 1});
            cnt++;
        }
        System.out.println(cnt);
    }
}