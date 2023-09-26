import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static int[][] map;
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        cnt = 0;
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - '0';
                if (map[i][j] == 0)
                    cnt++;
            }
        }
        findSdoku(0);
    }

    static void findSdoku(int n) {
        if (n == cnt) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            isEnd = true;
            return;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) {
                    List<Integer> list = findNum(i, j);
                    for (int k = 0; k < list.size(); k++) {
                        map[i][j] = list.get(k);
                        findSdoku(n + 1);
                        map[i][j] = 0;
                        if (isEnd) return;
                    }
                    if(map[i][j]==0) return;
                }
            }
        }
    }

    static List<Integer> findNum(int x, int y) {

        List<Integer> list = new ArrayList<>();
        boolean[] checked = new boolean[10];
        for (int i = 0; i < 9; i++) {
            checked[map[x][i]] = true;
            checked[map[i][y]] = true;
        }
        for (int i = 0 + 3 * (x / 3); i < 3 + 3 * (x / 3); i++) {
            for (int j = 0 + 3 * (y / 3); j < 3 + 3 * (y / 3); j++) {
                checked[map[i][j]] = true;
            }
        }
        for (int i = 1; i < 10; i++) {
            if (!checked[i])
                list.add(i);
        }
        return list;
    }
}