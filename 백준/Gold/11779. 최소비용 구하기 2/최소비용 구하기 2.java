import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Type{
    int v;
    int weight;
    String cities;

    public Type(int v, int weight, String cities) {
        this.v = v;
        this.weight = weight;
        this.cities = cities;
    }

}
public class Main {
    static int n,m;
    static ArrayList<Type>[] arr;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Type(b, c, ""));

        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist[s] = 0;
        dijkstra(s, e);
    }

    static void dijkstra(int s, int e) {
        PriorityQueue<Type> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Type(s, 0, "" + s));

        while (!pq.isEmpty()) {
            Type t = pq.poll();
            if (t.v == e) {
                System.out.println(t.weight);
                String[] city = t.cities.split("-");
                System.out.println(city.length);
                for (int i = 0; i < city.length; i++) {
                    System.out.print(city[i]+" ");
                }
                break;
            }
            for (int i = 0; i < arr[t.v].size(); i++) {
                Type next = arr[t.v].get(i);
                if (next.weight + t.weight < dist[next.v]) {
                    dist[next.v] = next.weight + t.weight;
                    pq.offer(new Type(next.v, dist[next.v], t.cities+"-"+next.v));
                }
            }
        }
    }
}