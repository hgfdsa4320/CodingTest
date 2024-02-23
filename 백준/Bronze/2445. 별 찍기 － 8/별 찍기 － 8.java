import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < i; j++) {
                tmp.append("*");
            }
            if (i != N) {
                for (int j = 0; j < N - i; j++) {
                    tmp.append(" ");
                }
            }
            if (i == N) {
                StringBuilder sb2 = new StringBuilder(sb);
                sb.append(tmp).append(tmp.reverse()).append(sb2.reverse());
            } else {
                sb.append(tmp).append(tmp.reverse()).append("\n");
            }
        }
        System.out.println(sb);
    }
}