import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = new int[m];
		visited = new boolean[n+1];
		permutation(0);		
	}
	static void permutation(int cnt) {
		if(cnt == m) {
			for(int i=0;i<cnt;i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();
		}else {
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					answer[cnt] = i;
					visited[i] = true;
					permutation(cnt+1);
					visited[i] = false;
					
				}
			}
		}
	}

}
