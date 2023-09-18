import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        int h = Integer.parseInt(br.readLine());
        Stack<String> st = new Stack<>();
        for (int i = 0; i < info.length; i++) {
            st.push(info[i]);
        }
        int[][] arr = new int[1][1];
        arr[0][0] = h;
        while (!st.isEmpty()) {
            int n = arr.length;
            int m = arr[0].length;
            int[][] tmp;
            String s = st.pop();
            if (s.equals("D")) {
                tmp = new int[n*2][m];
                for (int i = n; i < n * 2; i++) {
                    for (int j = 0; j < m; j++) {
                        tmp[i][j] = arr[i-n][j];
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        tmp[i][j] = tmp[tmp.length - 1 - i][j] >= 2 ? tmp[tmp.length - 1 - i][j] - 2 : tmp[tmp.length - 1 - i][j] + 2;
                    }
                }
            } else if (s.equals("U")) {
                tmp = new int[n * 2][m];
                for (int i = 0; i < n ; i++) {
                    for (int j = 0; j < m; j++) {
                        tmp[i][j] = arr[i][j];
                    }
                }
                for (int i = n; i < n*2; i++) {
                    for (int j = 0; j < m; j++) {
                        tmp[i][j] = tmp[tmp.length - 1 - i][j] >= 2 ? tmp[tmp.length - 1 - i][j] - 2 : tmp[tmp.length - 1 - i][j] + 2;
                    }
                }
            } else if (s.equals("R")) {
                tmp = new int[n][m * 2];
                for (int i = 0; i < n ; i++) {
                    for (int j = m; j < m*2; j++) {
                        tmp[i][j] = arr[i][j-m];
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        tmp[i][j] = tmp[i][tmp[0].length - 1 - j] %2==0 ? tmp[i][tmp[0].length - 1 - j] +1 : tmp[i][tmp[0].length - 1 - j] -1;
                    }
                }
            } else {
                tmp = new int[n][m * 2];
                for (int i = 0; i < n ; i++) {
                    for (int j = 0; j < m; j++) {
                        tmp[i][j] = arr[i][j];
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = m; j < m*2; j++) {
                        tmp[i][j] = tmp[i][tmp[0].length - 1 - j] %2==0 ? tmp[i][tmp[0].length - 1 - j] +1 : tmp[i][tmp[0].length - 1 - j] -1;
                    }
                }
            }
            arr = tmp;

        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}