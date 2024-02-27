import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = arr[N];
        boolean isOkay = false;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(arr[N]);
        for (int i = N - 1; i >= 1; i--) {
            pq.offer(arr[i]);
            if (arr[i] < min) {
                min = arr[i];
            } else {
                List<Integer> tmp = new ArrayList<>();
                while (!pq.isEmpty()) {
                    int t = pq.poll();
                    if (t < arr[i]) {
                        arr[i] = t;
                        for (int j = 0; j < tmp.size(); j++) {
                            pq.offer(tmp.get(j));
                        }
                        int idx = i+1;
                        while (!pq.isEmpty()) {
                            arr[idx++] = pq.poll();
                        }
                    } else {
                        tmp.add(t);
                    }
                }
                isOkay = true;
                break;
            }
        }
        if (isOkay) {
            for (int i = 1; i <= N; i++) {
                System.out.print(arr[i]+" ");
            }
        } else {
            System.out.println(-1);
        }
    }
}