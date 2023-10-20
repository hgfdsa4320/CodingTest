import java.io.*;
import java.util.*;

public class Main {
    static int[] alpha;
    static int answer = 0;
    static String[] arr;
    static PriorityQueue<int[]> pq;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        arr = new String[n];
        alpha = new int[26];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            for (int j = arr[i].length()-1; j >= 0; j--) {
                alpha[arr[i].charAt(j) - 'A'] += Math.pow(10, arr[i].length()-1-j);
            }
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0) {
                pq.offer(new int[]{i, alpha[i]});
            }
        }
        int cnt = 9;
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int idx = poll[0];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].replace((char) (idx + 'A'), (char) (cnt + '0'));
            }
            cnt--;
        }
        for (int i = 0; i < arr.length; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        System.out.println(sum);
    }
}