import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] dist;
    static boolean[] visited;
    static int k;
    static PriorityQueue<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        res = new PriorityQueue<>();
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        dist[x] = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        findDistance(x, 0);
        if (res.size() == 0) {
            System.out.println(-1);
        } else {
            while (!res.isEmpty()) {
                System.out.println(res.poll());
            }
        }
    }

    static void findDistance(int v, int dis) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{v, dis});
        visited[v] = true;
        while (!q.isEmpty()) {
            v = q.peek()[0];
            dis = q.poll()[1];
            if (dis == k) {
                res.offer(v);
            } else if (dis < k){
                for (int i = 0; i < list[v].size(); i++) {
                    int next = list[v].get(i);
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(new int[]{next, dis + 1});
                    }
                }
            }

        }

    }
}