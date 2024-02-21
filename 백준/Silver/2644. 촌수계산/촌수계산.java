import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class QueueInput {
    int v;
    int cnt;

    public QueueInput(int v, int cnt) {
        this.v = v;
        this.cnt = cnt;
    }
}
public class Main {
    static int n;
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }
        System.out.println(bfs(a, b));
    }

    static int bfs(int x, int y) {
        PriorityQueue<QueueInput> pq = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
        boolean[] visited = new boolean[n + 1];
        pq.offer(new QueueInput(x, 0));
        visited[x] = true;

        while (!pq.isEmpty()) {
            QueueInput q = pq.poll();
            int v = q.v;
            int cnt = q.cnt;
            if (v == y) {
                return cnt;
            }
            for (int i = 0; i < arr[v].size(); i++) {
                int next = arr[v].get(i);
                if (!visited[next]) {
                    pq.offer(new QueueInput(next, cnt + 1));
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}