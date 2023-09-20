import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int size = 2;
        int remain = 2;
        List<int[]> list = new ArrayList<>();
        List<Integer> fishSize = new ArrayList<>();// 물고기의 크기가 들어있음
        map = new int[n][n];

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    map[i][j] = 0;
                    x=i;
                    y=j;
                } else if (map[i][j] != 0) {
                    list.add(new int[]{map[i][j], i, j});
                    fishSize.add(map[i][j]);
                }
            }
        }
        Collections.sort(fishSize);
        int answer = 0;
        while (fishSize.size()>0 && size > fishSize.get(0)) {
            int t = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0] < size) {
                    if (getTime(x, y, list.get(i)[1], list.get(i)[2],size) < t) {
                        minIdx = i;
                        t = getTime(x, y, list.get(i)[1], list.get(i)[2],size);
                    }
                }
            }
            if(minIdx==-1) break;
            remain--;
            if (remain == 0) {
                size++;
                remain = size;
            }

            x = list.get(minIdx)[1];
            y = list.get(minIdx)[2];
            fishSize.remove(Integer.valueOf(list.get(minIdx)[0]));
            list.remove(minIdx);
            answer+=t;
        }
        System.out.println(answer);
    }

    static int getTime(int x, int y, int px, int py,int size) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            int time = tmp[2];
            if (x == px && y == py) {
                return time;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] <= size) {
                    q.offer(new int[]{nx, ny, time + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}