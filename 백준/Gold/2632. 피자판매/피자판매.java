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

        //피자 크기 별로 map에 넣어줌
        for (int i = 0; i < a; i++) {
            int size = 0;
            //시작 점이 i이고 거기서부터 매번 하나씩 더해줌(연속된 피자의 합 확인)
            for (int j = 0; j < a; j++) {
                //j==a-1인 경우는 전부 다 확인한 경운데 이는 i==0에서만 확인해야지 중복이 안됨
                if(i!=0 && j==a-1) break;
                // 범위를 넘으면 %a로 나눠줌으로써 범위 문제 해결
                size += pizza1[(i + j) % a];
                //연속된 피자 합이 n이하면 맵에 넣어줌
                if (size <= n) {
                    pizza1Size.put(size, pizza1Size.getOrDefault(size, 0) + 1);
                    // 연속된 피자 합이 n보다 크다면 종료(더 이상 더해줘봤자 무조건 더 큼)
                } else {
                    break;
                }
            }
        }
        //위와 같음
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
        int answer = 0;
        // key값이 연속된 피자 합이므로 keySet에서 key값들을 불러옴
        for (Integer key : pizza1Size.keySet()) {
            //key==n이면 그냥 그 개수 더해줌
            if (key == n) {
                answer += pizza1Size.get(key);
                //  전체 목표 피자-현재 연속된 피자가 pizza2Size에 존재한다면 그 둘의 개수를 곱한 것 만큼 더함
            } else if (pizza2Size.containsKey(n - key)) {
                answer += pizza1Size.get(key) * pizza2Size.get(n - key);
            }
        }
        //pizza2Size가 key값으로 n을 포함한다면 더해줌 
        if (pizza2Size.containsKey(n)) {
            answer += pizza2Size.get(n);
        }
        System.out.println(answer);
    }
}