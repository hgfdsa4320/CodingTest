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
            for (int j = 0; j < N - i; j++) {
                tmp.append(" ");
            }
            for (int j = 0 ; j < i * 2 - 1; j++) {
                tmp.append("*");
            }
            sb.append(tmp).append("\n");
        }
        for (int i = N - 1; i >= 1; i--) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < N - i; j++) {
                tmp.append(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                tmp.append("*");
            }
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }
}