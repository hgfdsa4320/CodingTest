import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{A, B, C});
        }
        boolean[] visited = new boolean[V + 1];
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (find(parent[p[0]]) != find(parent[p[1]])) {
                ans += p[2];
                visited[p[0]] = true;
                visited[p[1]] = true;
                union(p[0], p[1]);
            }
        }
        System.out.println(ans);
    }

    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) {
            return true;
        } else {
            if (A < B) {
                parent[B] = A;
            } else {
                parent[A] = B;
            }
            return false;
        }
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}