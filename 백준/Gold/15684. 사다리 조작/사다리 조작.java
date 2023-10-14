import java.io.*;
import java.util.*;

public class Main {
    static int answer, n, m, h;
    static boolean isPossible;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new boolean[h + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true; // a,b가 true면 a번째 가로줄에 b번째 세로줄과 b+1번째 세로줄이 연결되어 있음을 알림
        }
        answer = 0;
        isPossible = false; // 가능한지 확인하는 변수
        for (int i = 0; i < 4; i++) {
            findNum(i,0); // 가로선을 추가할 개수 i(0~3)
            if(isPossible) break; //가능하면 바로 중지
        }
        if (isPossible) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    static void findNum(int num,int cnt) {
        if (cnt == num) {
            if (isOkay()) {
                isPossible = true;
                answer = cnt;
            }
            return;
        }
        for (int now = 1; now < n; now++) { // 가로선은 1부터 n-1번째 세로줄에만 추가할 수 있음
            for (int i = 1; i <= h; i++) {
                // 현재 지점에 이미 가로줄이 있거나, 양 옆에 가로줄이 있으면 안됨
                if (map[i][now] || (now - 1 > 0 && map[i][now - 1]) || (now + 1 <= n && map[i][now + 1]))
                    continue;
                map[i][now] = true;
                findNum(num,cnt + 1);
                map[i][now] = false;
//                if(isPossible) return; //만약 됐으면 return
            }
        }

    }
    static boolean isOkay() {
        int[] tmp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tmp[i] = i;
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j]) {
                    int temp = tmp[j];
                    tmp[j] = tmp[j + 1];
                    tmp[j + 1] = temp;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (tmp[i] != i)
                return false;
        }
        return true;
    }
}