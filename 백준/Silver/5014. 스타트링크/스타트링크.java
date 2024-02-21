import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 */

class QInput {
    int v;
    int cnt;

    public QInput(int v, int cnt) {
        this.v = v;
        this.cnt = cnt;
    }
}
public class Main {
    static int F,S,G,U, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int answer = bfs();
        if (answer == -1) {
            System.out.println("use the stairs");
        } else System.out.println(answer);

    }

    static int bfs() {
        PriorityQueue<QInput> pq = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
        boolean[] visited = new boolean[F + 1];
        visited[S] = true;
        pq.offer(new QInput(S, 0));

        while (!pq.isEmpty()) {
            QInput q = pq.poll();
            int v = q.v;
            int cnt = q.cnt;
            if (v == G) {
                return cnt;
            }
            if (v + U <= F && !visited[v + U]) {
                pq.offer(new QInput(v + U, cnt + 1));
                visited[v + U] = true;
            }
            if (v - D >= 1 && !visited[v - D]) {
                pq.offer(new QInput(v - D, cnt + 1));
                visited[v - D] = true;
            }
        }
        return -1;
    }
}