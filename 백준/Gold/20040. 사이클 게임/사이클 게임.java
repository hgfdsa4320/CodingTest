import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean isCircle = false;
        int answer = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!isCircle) {
                if (!union(find(a),find(b))) {
                    answer = i;
                    isCircle = true;
                }
            }
        }
        if (isCircle) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) {
            return false;
        } else {
            if (A < B) {
                parent[b] = A;
            } else {
                parent[a] = B;
            }
            return true;
        }
    }
}