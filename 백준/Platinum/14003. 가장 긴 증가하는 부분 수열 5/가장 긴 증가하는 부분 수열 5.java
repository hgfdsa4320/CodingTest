import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] place = new int[n + 1];
        Arrays.fill(place, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1, arr[1]});
        place[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] > list.get(list.size() - 1)[1]) {
                place[i] = list.get(list.size() - 1)[0];
                list.add(new int[] {i, arr[i]});
            } else {
                int idx = findIdx(list, arr[i]);
                if (idx == 0) {
                    place[i] = 0;
                } else {
                    place[i] = list.get(idx - 1)[0];
                }
                list.set(idx, new int[] {i, arr[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        int idx = list.get(list.size() - 1)[0];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[idx]);
        while (true) {
            idx = place[idx];
            if (idx == 0) {
                break;
            }
            stack.push(arr[idx]);
        }
        System.out.println(list.size());
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static int findIdx(List<int[]> list, int v) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid)[1] < v) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/**
 * -61 -28 -72  59  13 -21  84 -76 -52 -1 -72
 * -76 -52  -21  -1
 * -61 -28
 *  0   1   0   2   2   2   6   0  0    0
 * 1
 *
 *
 */