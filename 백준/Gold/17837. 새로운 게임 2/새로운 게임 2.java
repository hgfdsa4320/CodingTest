import java.io.*;
import java.util.*;

public class Main {
    static class Horse {
        int no;
        int x;
        int y;
        int d;

        public Horse(int no, int x, int y, int d) {
            this.no = no;
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public String toString(){
            return no+" "+x+" "+y+" "+d;
        }
    }

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[][] map;
    static Stack<Horse>[][] horseMap;
    static Map<Integer, int[]> horsePlace = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        horseMap = new Stack[n + 1][n + 1];
        horsePlace = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                horseMap[i][j] = new Stack<>();
            }
        }
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            horseMap[x][y].push(new Horse(i, x, y, d));
            horsePlace.put(i, new int[]{x, y});
        }
        int t = 1;
        Loop1:
        while (t <= 1000) {
            for (int i = 1; i <= k; i++) {
                int[] tmp = horsePlace.get(i);
                int x = tmp[0];
                int y = tmp[1];
                Deque<Horse> dq = new LinkedList<>();
                int d;
                while (true) {
                    Horse h = horseMap[x][y].pop();
                    dq.offerLast(h);
                    if(h.no==i){
                        d = h.d;
                        break;
                    }
                }
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx > 0 && nx <= n && ny > 0 && ny <= n && map[nx][ny] != 2) {
                    if (map[nx][ny] == 0) {
                        while (!dq.isEmpty()) {
                            Horse h = dq.pollLast();
                            horseMap[nx][ny].push(h);
                            horsePlace.put(h.no, new int[]{nx, ny});
                        }
                        if (horseMap[nx][ny].size() >= 4) {
                            break Loop1;
                        }
                    } else if (map[nx][ny] == 1) {
                        while (!dq.isEmpty()) {
                            Horse h = dq.pollFirst();
                            horseMap[nx][ny].push(h);
                            horsePlace.put(h.no, new int[]{nx, ny});
                        }
                        if (horseMap[nx][ny].size() >= 4) {
                            break Loop1;
                        }
                    }
                } else {
                    nx = x - dx[d];
                    ny = y - dy[d];
                    Horse h = dq.pollLast();
                    h.d = h.d % 2 == 1 ? h.d + 1 : h.d - 1;
                    dq.offerLast(h);
                    if (nx > 0 && nx <= n && ny > 0 && ny <= n && map[nx][ny] != 2) {
                        if (map[nx][ny] == 0) {
                            while (!dq.isEmpty()) {
                                h = dq.pollLast();
                                horseMap[nx][ny].push(h);
                                horsePlace.put(h.no, new int[]{nx, ny});
                            }
                            if (horseMap[nx][ny].size() >= 4) {
                                break Loop1;
                            }
                        } else if (map[nx][ny] == 1) {
                            while (!dq.isEmpty()) {
                                h = dq.pollFirst();
                                horseMap[nx][ny].push(h);
                                horsePlace.put(h.no, new int[]{nx, ny});
                            }
                            if (horseMap[nx][ny].size() >= 4) {
                                break Loop1;
                            }
                        }

                    }else{
                        while (!dq.isEmpty()) {
                            h = dq.pollLast();
                            horseMap[x][y].push(h);
                        }
                    }
                }
            }
            t++;
        }
        if (t <= 1000) {
            System.out.println(t);
        }else{
            System.out.println(-1);
        }

    }
}