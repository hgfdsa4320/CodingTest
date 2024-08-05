import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


/**
 * Stack에 넣어놓고 빼면서 값이 다르면 +1
 * 1 2 3 5 10
 * 정렬(Arrays.sort())해서 반대로 탐색
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            st.push(arr[i]);
        }
        Arrays.sort(arr);
        int answer = 1;
        for (int i = N; i > 0; i--) {
            if (st.peek() < arr[i]) {
                answer++;
            } else {
                st.pop();
            }
        }
        System.out.println(answer);
    }
}