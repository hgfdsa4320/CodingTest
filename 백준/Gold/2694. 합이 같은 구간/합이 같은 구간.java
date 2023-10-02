import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int m = Integer.parseInt(br.readLine());

            List<Integer> sumList = new ArrayList<>();
            Set<Integer> sumSet = new HashSet<>();

            int prev = 0;
            int idx = 0;
            Loop1:
            for (int i = 0; i <= m / 10; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 10; j++) {
                    int now = Integer.parseInt(st.nextToken());
                    sumList.add(prev + now);
                    sumSet.add(prev + now);
                    prev += now;
                    idx++;
                    if (idx == m) break Loop1;
                }
            }
            int maxValue = sumList.get(m - 1);
            int min = 0;
            while (true) {
                int diff = sumList.get(min);
                int now = diff;
                boolean flag = true;
                while (true) {
                    if (now == maxValue) {
                        break;
                    }
                    int next = now + diff;
                    if (sumSet.contains(next)) {
                        now = next;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                min++;
            }
            System.out.println(sumList.get(min));
        }
    }
}