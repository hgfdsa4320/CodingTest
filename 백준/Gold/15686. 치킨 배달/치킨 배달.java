import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static int n,m;
    static int answer;
    static boolean[] open;
    static List<int[]> home;
    static List<int[]> store;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        home = new ArrayList<>();
        store = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new int[]{i,j});
                }
                else if(map[i][j]==2){
                    store.add(new int[]{i,j});
                }
            }
        }
        open = new boolean[store.size()];
        dfs(0,0);
        System.out.println(answer);

    }
    static void dfs(int start, int cntChicken){
        if(cntChicken==m){
            answer = Math.min(answer,getDistance());
        }else{
            for (int i = start; i < store.size(); i++) {
                open[i] = true;
                dfs(i+1,cntChicken+1);
                open[i] = false;
            }
        }
    }

    static int getDistance(){
        int res =0;
        for(int i=0;i<home.size();i++){
            int distance = Integer.MAX_VALUE;
            for(int j=0;j<store.size();j++){
                if (open[j]) {
                    int[] tmp = store.get(j);
                    int[] disHome = home.get(i);
                    distance = Math.min(distance,Math.abs(tmp[0]-disHome[0])+Math.abs(tmp[1]-disHome[1]));
                }

            }
            res+=distance;
        }

        return res;

    }
}