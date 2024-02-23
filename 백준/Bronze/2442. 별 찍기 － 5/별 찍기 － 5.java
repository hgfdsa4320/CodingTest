import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = N; i >= 1; i--) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < N - i; j++) {
                tmp.append(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                tmp.append("*");
            }
            sb.append(tmp.reverse());
            if (i != 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb.reverse().toString());
    }
}