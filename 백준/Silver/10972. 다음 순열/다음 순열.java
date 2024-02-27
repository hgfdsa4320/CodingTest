import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 끝에서 부터 수를 확인(가장 작은 수가 아니면 그 거보다 작은 수가 나올때까지 찾음)
 * (가장 작은 수면 그 앞수를 확인)
 * 그보다 작은 수를 찾으면 현재 수랑 찾은 수를 교체하고 뒤에는 그냥 정렬
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean isCheck = false;
        int max = arr[n];
        pq.offer(arr[n]);
        for (int i = n - 1; i >= 1; i--) {
            pq.offer(arr[i]);
            if (arr[i] > max) {
                max = arr[i];

            } else {
                List<Integer> tmp = new ArrayList<>();
                while (!pq.isEmpty()){
                    int t = pq.poll();
                    if (t > arr[i]) {
                        arr[i] = t;
                        for (int j = 0; j < tmp.size(); j++) {
                            pq.offer(tmp.get(j));
                        }
                        break;
                    } else {
                        tmp.add(t);
                    }
                }
                for (int j = i+1; j <= n; j++) {
                    arr[j] = pq.poll();
                }
                isCheck = true;
                break;
            }
        }
        if (!isCheck) {
            System.out.println(-1);
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}