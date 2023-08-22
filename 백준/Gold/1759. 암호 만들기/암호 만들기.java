import java.io.*;
import java.util.*;

public class Main {
	static Set<String> set;
	static int l,c;
	static boolean[] visited;
	static String[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr =new String[c];
		sb = new StringBuilder();
		visited = new boolean[c];
		String s =br.readLine();
		arr = s.split(" ");
		Arrays.sort(arr);
		set = new HashSet<>();
		set.add("a");
		set.add("e");
		set.add("i");
		set.add("o");
		set.add("u");
		dfs(0,"",0,0);
		System.out.println(sb.toString());
		
	}
	static void dfs(int start,String s,int a, int b) {
		if(s.length()==l && a>=1 && b>=2) {
			sb.append(s).append("\n");
			return;
		}
		for(int i=start;i<c;i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(set.contains(arr[i])) {
					dfs(i+1,s+arr[i],a+1,b);	
				}else {
					dfs(i+1,s+arr[i],a,b+1);
				}		
				visited[i] = false;
			}
		}
	}

}