import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{s, e});
        }
        int[][] arr = new int[n][367];
        while (!pq.isEmpty()) {
            int a = pq.peek()[0];
            int b = pq.poll()[1];
            for (int i = 0; i < n; i++) {
                if (arr[i][a] == 0) {
                    for (int j = a; j <= b; j++) {
                        arr[i][j] = 1;
                    }
                    break;
                }
            }
        }
        int[] tmp = new int[367];
        for (int i = 1; i < 367; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == 1) {
                    tmp[i] = Math.max(tmp[i], j+1);
                }
            }
        }
        int width = 0;
        int height = 0;
        int answer = 0;
        for (int i = 1; i < 367; i++) {
            height = Math.max(height, tmp[i]);
            width++;
            if (tmp[i] == 0) {
                width--;
                answer += width * height;
                width = 0;
                height = 0;
            }
        }
        System.out.println(answer);
    }

}