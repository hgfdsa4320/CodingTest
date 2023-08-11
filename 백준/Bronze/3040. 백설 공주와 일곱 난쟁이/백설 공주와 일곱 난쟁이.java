import java.io.*;

public class Main {
	static boolean[] visited;
	static int[] answer;
	static int[] arr;
	static int idx;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new int[7];
		arr =new int[9];
		visited = new boolean[9];
		idx = 0;
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0,0);
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
	static void dfs(int cnt,int sum) {
		if(cnt==7) {
			if(sum==100) {
				int idx = 0;
				for(int i=0;i<9;i++) {
					if(visited[i]) answer[idx++] = arr[i];
				}
			}
			return;
		}
		for(int i=idx;i<9;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1,sum+arr[i]);
				visited[i] = false;
			}
		}
	}

}