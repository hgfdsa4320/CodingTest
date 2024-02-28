import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] arr = new ArrayList[N + 1];
        int[] D = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            D[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) {
                pq.offer(i);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            int x = pq.poll();
            res.append(x + " ");
            for (int i = 0; i < arr[x].size(); i++) {
                int next = arr[x].get(i);
                D[next]--;
                if (D[next] == 0) {
                    pq.offer(next);
                }
            }
        }
        System.out.println(res);
    }
}