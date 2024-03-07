import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class P {
    int from;
    int to;
    double cost;

    public P(int from, int to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        double[][] point = new double[n + 1][2];
        double ans = 0;
        PriorityQueue<P> pq = new PriorityQueue<>((a,b)->(int)(a.cost-b.cost));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            point[i + 1] = new double[]{x, y};
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                pq.offer(new P(i, j, getDistance(point[i], point[j])));
            }
        }
        while (!pq.isEmpty()) {
            P p = pq.poll();
            if (find(parent[p.from]) == find(parent[p.to])) {
                continue;
            }
            union(p.from, p.to);
            ans += Math.sqrt(p.cost);
        }
        System.out.printf("%.2f",ans);

    }

    static double getDistance(double[] p1, double[] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }


    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if(A == B) return;

        if (A < B) {
            parent[B] = A;
        } else {
            parent[A] = B;
        }
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}