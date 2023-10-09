import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a < b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            int k = findGCD(a, b);
            System.out.println(a/k*b);
        }
    }

    static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b,a % b);
    }
}