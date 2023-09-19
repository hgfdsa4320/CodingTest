import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int n,m,answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 0;
		int end = arr[n-1];
		
		while(start<=end) {
			int mid = (start+end)/2;
			long sum = sumTree(mid);
			if(sum==m) {
				answer = mid;
				break;
			}else if(sum<m) {
				end = mid-1;
			}else {
				answer = Math.max(answer,mid);
				start = mid+1;
			}
		}
		System.out.println(answer);
	}
	static long sumTree(int height) {
		long sum = 0;
		for(int i=0;i<n;i++) {
			if(arr[i]-height>0) {
				sum+=arr[i]-height;
			}
		}
		return sum;
	}
}