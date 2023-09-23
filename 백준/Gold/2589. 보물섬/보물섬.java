import java.io.*;
import java.util.*;



public class Main {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> list;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'L') {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            visited = new boolean[n][m];
            findDistance(i);
        }
        System.out.println(answer);
    }

    static void findDistance(int a) {
        Queue<int[]> q = new LinkedList<>();
        int x = list.get(a)[0];
        int y = list.get(a)[1];
        q.offer(new int[]{x, y,0});
        visited[x][y] = true;

        while ((!q.isEmpty())) {
            x = q.peek()[0];
            y = q.peek()[1];
            int cnt =q.poll()[2];
            answer = Math.max(answer, cnt);
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 'L' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny,cnt+1});
                }
            }
        }
    }
}