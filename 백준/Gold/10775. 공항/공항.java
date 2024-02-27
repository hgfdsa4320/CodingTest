import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        boolean isEnd = false;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            if (!union(g - 1, g)) {
                isEnd = true;
                System.out.println(i);
                break;
            }
        }
        if (!isEnd) {
            System.out.println(P);
        }
    }

    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if (A == B) {
            if (A == 0) {
                return false;
            }
            union(find(a-1), a);
        }
        parent[b] = A;
        return true;
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}