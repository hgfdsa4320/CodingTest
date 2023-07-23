import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    static int[][] lines;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 0;test<t;test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            d = (d<0)?360+d:d;
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            lines = new int[4][n];
            for (int i = 0; i < n; i++) {
                lines[0][i] = arr[n/2][i];
                lines[1][i] = arr[i][i];
                lines[2][i] = arr[i][n/2];
                lines[3][i] = arr[i][n-1-i];
            }
            int cnt = d/45;
            for (int i = 0; i < cnt; i++) {
                lines = rotateArr(lines);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                arr[n/2][i] = lines[0][i];
                arr[i][i] = lines[1][i];
                arr[i][n / 2] = lines[2][i];
                arr[i][n - 1 - i] = lines[3][i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                if (i != n-1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }
    }
    static int[][] rotateArr(int[][] arr){
        int[][] tmpArr = new int[arr.length][arr[0].length];
        tmpArr[3] = arr[2].clone();
        tmpArr[2] = arr[1].clone();
        tmpArr[1] = arr[0].clone();
        tmpArr[0] = arr[3].clone();
        for (int i = 0; i < arr[0].length/2; i++) {
            int tmp = tmpArr[0][i];
            tmpArr[0][i] = tmpArr[0][arr[0].length - i - 1];
            tmpArr[0][arr[0].length - i - 1] = tmp;
        }
        return tmpArr;
    }
}