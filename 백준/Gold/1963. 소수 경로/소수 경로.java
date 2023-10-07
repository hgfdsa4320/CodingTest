import java.io.*;
import java.util.*;

public class Main {
    static boolean isNum[];
    static int target;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isNum = new boolean[10000];
        for (int i = 2; i <= Math.sqrt(10000); i++) {
            if(isNum[i]) continue;
            for (int j = i + i; j < 10000; j += i) {
                isNum[j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            target = Integer.parseInt(st.nextToken());
            int answer = findCount(a, 0);
            if (answer == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(answer);
            }
        }
    }

    static int findCount(String num, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{Integer.parseInt(num), cnt});
        set = new HashSet<>();
        set.add(Integer.parseInt(num));
        while (!q.isEmpty()) {
            int now = q.peek()[0];
            cnt = q.poll()[1];
            if (now == target) {
                return cnt;
            }
            num = String.valueOf(now);
            for (int i = 0; i < 4; i++) {
                String start = "";
                String end = "";
                if (i != 0) {
                    start = num.substring(0, i);
                }
                if (i != 3) {
                    end = num.substring(i + 1);
                }
                for (int j = 0; j < 10; j++) {
                    int next = Integer.parseInt(start + j + end);
                    if (next >= 1000 && !isNum[next] && !set.contains(next)) {
                        set.add(next);
                        q.offer(new int[]{next, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }
}