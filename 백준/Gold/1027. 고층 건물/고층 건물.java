import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        //n이 50이 최대이므로 걍 다돌아도 몇 개 안됨
        
        //기울기를 기준으로 현재 다른 건물과의 기울기보다 더 커져야만 볼 수 있다. 더 작으지면 못 봄
        for (int now = 0; now < n; now++) { //현재 빌딩 넘버
            int cnt = 0; //현재 빌딩에서 볼 수 있는 건물 수
            int left = now - 1; // 현재 빌딩을 기준으로 바로 왼쪽 빌딩
            double leftMax = Integer.MIN_VALUE; // 왼쪽 빌딩과의 최대 기울기
            int right = now + 1;
            double rightMax = Integer.MIN_VALUE;
            for (int i = left; i >= 0; i--) {
                double incline = (double)(arr[i]-arr[now])/(now-i);
                if (incline > leftMax) {
                    cnt++;
                    leftMax = incline;
                }
            }
            for (int i = right; i < n; i++) {
                double incline = (double)(arr[i]-arr[now])/(i-now);
                if (incline > rightMax) {
                    cnt++;
                    rightMax = incline;
                }

            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}