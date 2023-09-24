import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static List<int[]> list;
    static boolean isEnd = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        findNum(0);
    }

    static void findNum(int cnt) {
        if (cnt == list.size()) {
            isEnd = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        int x = list.get(cnt)[0];
        int y = list.get(cnt)[1];
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
            if (!checked[i]) {
                checked[i] = true;
                map[x][y] = i;
                findNum(cnt + 1);
                if(isEnd) return;
                checked[i] = false;
                map[x][y] = 0;
            }
        }
    }
}