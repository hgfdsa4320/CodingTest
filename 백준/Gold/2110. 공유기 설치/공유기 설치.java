import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int n,c,answer;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		answer = 0; 
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int[] diff = new int[n-1];
		for(int i=1;i<n;i++) {
			diff[i-1] = arr[i]-arr[i-1];
		}
		Arrays.sort(diff);
		int start = 0;
		int end = arr[arr.length-1]-arr[0];
		while(start<=end) {
			int mid = (start+end)/2;
			flag = false;
			if(check(mid)) {
				if(flag)
					answer = Math.max(answer, mid);
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		System.out.println(answer);
	}
	static boolean check(int distance) {
		int cnt = 0;
		int prev = arr[0];
		for(int i=1;i<n;i++) {
			if(arr[i]-prev>=distance) {
				if(arr[i]-prev==distance) flag = true;
				cnt++;
				prev = arr[i];
			}
		}
		if(cnt>=c-1) return true;
		return false;
	}
	
	
}