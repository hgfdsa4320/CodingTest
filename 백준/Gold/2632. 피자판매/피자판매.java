import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] pizza1 = new int[a];
        int[] pizza2 = new int[b];

        for (int i = 0; i < a; i++) {
            pizza1[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < b; i++) {
            pizza2[i] = Integer.parseInt(br.readLine());
        }

        // (연속된 피자 크기, 해당 피자 크기의 개수)
        Map<Integer, Integer> pizza1Size = new HashMap<>();
        Map<Integer, Integer> pizza2Size = new HashMap<>();

        for (int i = 0; i < a; i++) {
            int size = 0;
            for (int j = 0; j < a; j++) {
                if(i!=0 && j==a-1) break;
                size += pizza1[(i + j) % a];
                if (size <= n) {
                    pizza1Size.put(size, pizza1Size.getOrDefault(size, 0) + 1);
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < b; i++) {
            int size = 0;
            for (int j = 0; j < b; j++) {
                if(i!=0 && j==b-1) break;
                size += pizza2[(i + j) % b];
                if (size <= n) {
                    pizza2Size.put(size, pizza2Size.getOrDefault(size, 0) + 1);
                } else {
                    break;
                }
            }
        }
        long answer = 0;
        for (Integer key : pizza1Size.keySet()) {
            if (key == n) {
                answer += pizza1Size.get(key);
            } else if (pizza2Size.containsKey(n - key)) {
                answer += pizza1Size.get(key) * pizza2Size.get(n - key);
            }
        }
        if (pizza2Size.containsKey(n)) {
            answer += pizza2Size.get(n);
        }
        System.out.println(answer);
    }
}