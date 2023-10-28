import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            }else{
                int idx = findIdx(list, arr[i]);
                list.set(idx, arr[i]);
            }
        }
        System.out.println(list.size());
    }

    static int findIdx(List<Integer> list, int v) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < v) {
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}