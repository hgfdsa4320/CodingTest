import java.io.*;
import java.util.*;

public class Main {
    static int answer=0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n,m;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int bx = 0; //파란공 위치
        int by = 0;
        int rx = 0; //빨간공 위치
        int ry = 0;

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
            }
        }
        isPossible(0,bx,by,rx,ry);
        System.out.println(answer);
    }

    static void isPossible(int cnt, int bx, int by, int rx, int ry) {
        for (int i = 0; i < 4; i++) {
            boolean flag = true; // 실행 가능한지 확인(파란색 구슬이 원에 들어가거나, 빨간색 공이 움직이지 않으면 false
            boolean isMeet = false; // 파란색공이 빨간색 공과 만났는지 확인
            int bnx = bx;
            int bny = by;
            while (true) {
                bnx = bnx + dx[i];
                bny = bny + dy[i];
                if (map[bnx][bny] == '#') {
                    bnx = bnx - dx[i];
                    bny = bny - dy[i];
                    break;
                } else if(bnx == rx && bny == ry){
                    isMeet = true;
                    break;
                }else if (map[bnx][bny] == 'O') {
                    flag = false;
                    break;
                }
            }

            int rnx = rx;
            int rny = ry;

            while (true) {
                if(!flag) break;
                rnx = rnx + dx[i];
                rny = rny + dy[i];
                if (map[rnx][rny] == '#' || (rnx == bnx && rny == bny)) {
                    rnx = rnx - dx[i];
                    rny = rny - dy[i];
                    break;
                } else if (map[rnx][rny] == 'O') {
                    if (isMeet) {
                        flag = false;
                        break;
                    }
                    answer = 1;
                    break;
                }
            }

            if (isMeet) {
                bnx = rnx - dx[i];
                bny = rny - dy[i];
            }

            if(answer==1) return;
            if (cnt == 10) return;
            if (flag) {
                isPossible(cnt+1,bnx,bny,rnx,rny);
            }
        }

    }
}