import java.io.*;
import java.util.*;

public class Main {
    static int n = 19;
    static int[][] arr;
    static int win = 0;
    static int[] res = new int[2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Loop1:
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j]!=0 && check(i, j)) {

                    break Loop1;
                }
            }
        }
        if (win == 0) {
            System.out.println(0);
        } else {
            System.out.println(win);
            System.out.println(res[0] + " " + res[1]);
        }

    }

    static boolean check(int x, int y) {
        int tmp = arr[x][y];
        int cnt = 1;
        int ny = y;
        //오른쪽 체크
        int prevX = x - 1;
        int prevY = y - 1;
        if ((prevY<0 || (prevY>=0 && arr[x][prevY]!=tmp)) &&  n - y >= 5) {
            while (true) {
                ny = ny+1;
                if (ny < n && arr[x][ny] == tmp) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == 5) {
                win = arr[x][y];
                res[0] = x+1;
                res[1] = y+1;
                return true;
            }

        }
        cnt = 1;
        int nx = x;
        //아래 체크
        if ((prevX<0 || (prevX>=0 && arr[prevX][y]!=tmp)) && n - x >= 5) {
            while (true) {
                nx = nx+1;
                if (nx < n && arr[nx][y] == tmp) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == 5) {
                win = arr[x][y];
                res[0] = x+1;
                res[1] = y+1;
                return true;
            }
        }

        cnt = 1;
        nx = x;
        ny = y;
        //오른쪽 아래 대각선 체크
        if ((prevX<0 || prevY<0 || (prevX>=0 && prevY>=0 && arr[prevX][prevY]!=tmp)) && n - y >= 5 && n - x >= 5) {
            while (true) {
                nx = nx+1;
                ny = ny+1;

                if (nx < n && ny < n && arr[nx][ny] == tmp) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == 5) {
                win = arr[x][y];
                res[0] = x+1;
                res[1] = y+1;
                return true;
            }

        }
        //왼쪽 아래 대각선
        cnt = 1;
        nx = x;
        ny = y;
        prevY = y+1;
        if (y >= 4 && n - x >= 5) {
            while (true) {
                nx = nx+1;
                ny = ny-1;

                if ((prevX<0 || prevY>=n || (prevX>=0 && prevY<n && arr[prevX][prevY]!=tmp)) && nx < n && ny >= 0 && arr[nx][ny] == tmp) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == 5) {
                win = arr[x][y];
                res[0] = x+5;
                res[1] = y-3;
                return true;
            }
        }
        return false;
    }
}