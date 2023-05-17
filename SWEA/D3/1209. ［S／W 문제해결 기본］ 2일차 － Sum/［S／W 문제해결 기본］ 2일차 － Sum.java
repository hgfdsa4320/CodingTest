import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int testNum = Integer.parseInt(br.readLine());

            int[][] arr = new int[100][100];
            int max = 0;
            for (int i = 0; i < 100; i++) {
                int tmp = 0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    tmp += arr[i][j];
                }
                if (tmp > max) {
                    max = tmp;
                }
            }
            for (int j = 0; j < 100; j++) {
                int tmp=0;
                for (int i = 0; i < 100; i++) {
                    tmp += arr[i][j];
                }
                if (tmp > max) {
                    max = tmp;
                }
            }
            int tmp = 0;
            for (int i = 0; i < 100; i++) {
                tmp += arr[i][i];
            }
            if (tmp > max) {
                max = tmp;
            }

            tmp = 0;
            for (int i = 0; i < 100; i++) {
                tmp += arr[i][99 - i];
            }
            if (tmp > max) {
                max = tmp;
            }
            System.out.printf("#%d %d\n",testNum,max);
        }
    }
}
