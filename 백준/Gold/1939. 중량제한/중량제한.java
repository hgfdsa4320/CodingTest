import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] arr;
    static int n,low,high;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        low = Integer.MAX_VALUE;
        high = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            low = Math.min(low, c);
            high = Math.max(high, c);
            arr[a].add(new int[]{b, c});
            arr[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer= 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(a,b,mid)) {
                answer = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static boolean isPossible(int a, int b, int mid) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(a);
        visited[a] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < arr[v].size(); i++) {
                if (arr[v].get(i)[1] >= mid && !visited[arr[v].get(i)[0]]) {
                    if (arr[v].get(i)[0] == b) {
                        return true;
                    }
                    q.offer(arr[v].get(i)[0]);
                    visited[arr[v].get(i)[0]] = true;
                }
            }
        }
        return false;
    }
}