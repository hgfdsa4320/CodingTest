import java.io.*;
import java.util.*;

class Solution {
    static char[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            arr = new char[8][8];
            for (int i = 0; i < 8; i++) {
                arr[i] = br.readLine().toCharArray();
            }
            int answer = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - n + 1; j++) {
                    if (checkRowPalindrome(n, i, j)) {
                        answer++;
                    }
                }
            }
            for (int j = 0; j< 8; j++) {
                for (int i = 0; i < 8 - n + 1; i++) {
                    if (checkColumPalindrome(n, i, j)) {
                        answer++;
                    }
                }
            }
            System.out.printf("#%d %d\n",test_case,answer);

        }
    }

    static boolean checkRowPalindrome(int n, int x, int y) {
        int start = y;
        int end = y + n - 1;
        while (start < end) {
            if (arr[x][start] != arr[x][end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    static boolean checkColumPalindrome(int n, int x, int y) {
        int start = x;
        int end = x + n - 1;
        while (start < end) {
            if (arr[start][y] != arr[end][y]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}