import java.io.*;
import java.util.*;

public class Solution {
	static int n,l,answer;
	static int[][] arr;
	static boolean[] visited;
	static int idx;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			arr = new int[n][2];
			visited = new boolean[n];
			answer = 0;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			idx =0;
			dfs(0,0);
			System.out.println("#"+tc+" "+answer);
		}
	}
	static void dfs(int score,int calorie) {
		answer = Math.max(answer,score);
		for(int i=idx;i<n;i++) {
			if(!visited[i] && calorie+arr[i][1]<=l) {
				visited[i] = true;
				dfs(score+arr[i][0],calorie+arr[i][1]);
				visited[i] = false;
				idx= i+1;
			}
		}
	}

}