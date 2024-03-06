import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] arr;
    static int[] prev;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] D = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            D[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) {
                q.offer(i);
            }
        }
        prev = new int[N + 1];
        int ans = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            int cnt = bfs(now);
            if (prev[now] + cnt == N - 1) {
                ans++;
            }
            for (int i = 0; i < arr[now].size(); i++) {
                int next = arr[now].get(i);
                D[next]--;
                if (D[next] == 0) {
                    q.offer(next);
                }
            }
        }
        System.out.println(ans);
    }

    static int bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[v] = true;
        q.offer(v);
        int cnt = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < arr[now].size(); i++) {
                int next = arr[now].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    prev[next]++;
                    cnt++;
                    q.offer(next);
                }
            }
        }
        return cnt;
    }
}