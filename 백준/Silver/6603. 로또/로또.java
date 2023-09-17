import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb;
    static boolean[] checked;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            n = Integer.parseInt(st.nextToken());
            arr = new int[n + 1];
            checked = new boolean[n + 1];
            if (n == 0) break;
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            findNum(1, 0);
            sb.append("\n");
            System.out.print(sb);
        }
    }

    static void findNum(int start,int cnt) {
        if (cnt == 6) {
            for (int i = 1; i <= n; i++) {
                if(checked[i]){
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            if (!checked[i]) {
                checked[i] = true;
                findNum(i + 1, cnt + 1);
                checked[i] = false;
            }
        }
    }
}