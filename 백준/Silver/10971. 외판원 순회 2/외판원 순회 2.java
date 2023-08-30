import java.io.*;
import java.util.*;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int[][] arr;
	static int n;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			findNum(i,i, 1, 0);
			visited[i] = false;
		}
		System.out.println(answer);

	}

	static void findNum(int start, int now, int cnt, int sum) {
		if(cnt==n ) {
			if(arr[now][start]!=0)
				answer = Math.min(answer, sum+arr[now][start]);
			return;
		}
		visited[now] = true;
		for(int i=0;i<n;i++) {
			if(!visited[i] && arr[now][i]!=0) {
				visited[i] = true;
				findNum(start,i,cnt+1,sum+arr[now][i]);
				visited[i] = false;
			}
		}
	}
}