import java.io.*;

public class Main {
    static StringBuilder sb;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        cnt = 0;
        move(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void move(int n, int start, int mid ,int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            cnt++;
        } else {
            move(n - 1, start, end, mid);
            move(1, start, mid, end);
            move(n - 1, mid, start, end);
        }
    }
}