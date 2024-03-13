import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 1 2 5
 *
 * 1 2 1
 * 2 1 3
 * 3 3 3
 *
 * R
 * 2 1 1 2 0 0
 * 1 1 2 1 3 1
 * 3 3 0 0 0 0
 *
 * C
 * 1 3 1 1 3 1
 * 1 1 1 1 1 1
 * 2 1 2 2 0 0
 * 1 2 1 1 0 0
 * 3 0 0 0 0 0
 * 1 0 0 0 0 0
 *
 *
 *
 * 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬한다.
 * R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
 * C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
 * 예를 들어, [3, 1, 1]에는 3이 1번, 1가 2번 등장한다. 따라서, 정렬된 결과는 [3, 1, 1, 2]가 된다.
 * 다시 이 배열에는 3이 1번, 1이 2번, 2가 1번 등장한다. 다시 정렬하면 [2, 1, 3, 1, 1, 2]가 된다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] A = new int[100][100];
        int leftLength = 3;
        int rightLength = 3;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = 0;
        while (t <= 100) {
            if (A[r-1][c-1] == k) {
                break;
            }
            if (leftLength >= rightLength) { // R 연산
                rightLength = 0;
                for (int i = 0; i < 100; i++) {
                    int[] tmp = new int[101];
                    for (int j = 0; j < 100; j++) {
                        tmp[A[i][j]]++;
                    }
                    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
                    for (int j = 1; j <= 100; j++) {
                        if (tmp[j] != 0) {
                            pq.offer(new int[] {j, tmp[j]});
                        }
                    }
                    int idx = 0;
                    while (!pq.isEmpty() && idx < 100) {
                        A[i][idx++] = pq.peek()[0];
                        A[i][idx++] = pq.poll()[1];
                    }
                    rightLength = Math.max(rightLength, idx);
                    while (idx < 100) {
                        A[i][idx++] = 0;
                    }

                }
            } else { // L 연산
                leftLength = 0;
                for (int i = 0; i < 100; i++) {
                    int[] tmp = new int[101];
                    for (int j = 0; j < 100; j++) {
                        tmp[A[j][i]]++;
                    }
                    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
                    for (int j = 1; j <= 100; j++) {
                        if (tmp[j] != 0) {
                            pq.offer(new int[] {j, tmp[j]});
                        }
                    }
                    int idx = 0;
                    while (!pq.isEmpty() && idx < 100) {
                        A[idx++][i] = pq.peek()[0];
                        A[idx++][i] = pq.poll()[1];
                    }
                    leftLength = Math.max(leftLength, idx);
                    while (idx < 100) {
                        A[idx++][i] = 0;
                    }
                }
            }
            t++;
        }
        System.out.println(t > 100 ? -1 : t);
    }
}