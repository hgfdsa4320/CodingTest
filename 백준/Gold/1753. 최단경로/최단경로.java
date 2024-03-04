import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node{
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        ArrayList<Node>[] arr = new ArrayList[V + 1];
        for (int i = 1; i <+ arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v, w));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        pq.offer(new Node(K, dist[K]));

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            visited[n.to] = true;
            for (int i = 0; i < arr[n.to].size(); i++) {
                Node next = arr[n.to].get(i);
                if (!visited[next.to] && n.weight + next.weight < dist[next.to]) {
                    dist[next.to] = n.weight + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));

                }
            }
        }

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }


}