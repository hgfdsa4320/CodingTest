import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            boolean isOkay = true;
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);
            for (int i = 1; i < n; i++) {
                if (arr[i].length() > arr[i - 1].length()) {
                    if (arr[i].indexOf(arr[i - 1]) == 0) {
                        isOkay = false;
                    }
                }
            }
            System.out.println(isOkay?"YES":"NO");
        }
    }
}