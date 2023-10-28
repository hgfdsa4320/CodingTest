import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static ArrayList<Integer> lis = new ArrayList<>();
	static int n;
	static int[] arr;
	
	public static void input() throws Exception {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static int get_lowerbound(int num) {
		int left,right,mid;
		left = 0;
		right = lis.size();
		while(left<right) {
			mid = (left+right)/2;
			if(lis.get(mid)<num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
	
	public static void solve() {
		lis.add(arr[0]);
		for(int i=1; i<n; i++) {
			if(arr[i]>lis.get(lis.size()-1)) {
				lis.add(arr[i]);
			} else {
				int index = get_lowerbound(arr[i]);
				lis.set(index, arr[i]);
			}
		}
		System.out.print(lis.size());
	}
	
	public static void main(String[] args) throws Exception {
		input();
		solve();
	}
}