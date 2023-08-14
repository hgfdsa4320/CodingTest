import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[100001];
        char prev = '0';
        List<Integer> lazer = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (prev == '(') {
                    st.pop();
                    lazer.add(i);
                } else {
                    int start = st.pop();
                    for (int j = start; j < i; j++) {
                        arr[j] += 1;
                    }
                }
            } else {
                st.push(i);
            }
            prev = s.charAt(i);
        }

        int answer = 0;
        int previous = 0;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > previous) {
                answer += arr[i] - previous;
            }
            if (idx < lazer.size() && i == lazer.get(idx)) {
                answer += arr[i];
                idx++;
            }
            previous = arr[i];
        }
        System.out.println(answer);
    }
}