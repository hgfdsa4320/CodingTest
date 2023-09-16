import java.io.*;
import java.util.*;

public class Main {
    static boolean[] arr = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(arr, true);
        StringBuilder sb = new StringBuilder();
        arr[1] = false;
        findNum();
        arr[2] = false;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            int start = 3;
            int end = n - 1;
            while (start <= end) {
                if (arr[start] && arr[end]) {
                    if (start + end == n) {
                        sb.append(n + " = " + start + " + " + end+"\n");
                        break;
                    } else if (start + end < n) {
                        start+=2;
                        while (!arr[start]) {
                            start+=2;
                        }
                    } else {
                        end-=2;
                        while (!arr[end]) {
                            end-=2;
                        }
                    }
                } else {
                    end-=2;
                    while (!arr[end]) {
                        end-=2;
                    }
                }
            }
            if (start > end) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }
        System.out.println(sb);
    }

    static void findNum() {
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if(!arr[i]) continue;
            for (int j = i + i; j < arr.length; j += i) {
                arr[j] = false;
            }
        }
    }
}