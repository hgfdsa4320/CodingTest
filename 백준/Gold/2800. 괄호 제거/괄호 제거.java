import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder answer;
	static List<int[]> list;
	static boolean[] visited;
	static Set<String> set; // 중복 확인
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Integer> st = new Stack<>();
		list = new ArrayList<>();
		answer = new StringBuilder();
		set = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==')') {
				list.add(new int[] {st.pop(),i});
			}else if(s.charAt(i)=='(') {
				st.push(i);
			}
		}
		for(int i=1;i<=list.size();i++) {
			visited = new boolean[list.size()];
			remove(i,s,0);
		}
		String[] res = answer.toString().split(" ");
		Arrays.sort(res);
		for(int i=0;i<res.length;i++) {
			if(!set.contains(res[i])) {
				System.out.println(res[i]);
				set.add(res[i]);
			}
		}
		
	}
	static void remove(int cnt,String s,int start) {
		if(cnt==0) {
			s = s.replace("k", "");
			answer.append(s).append(" ");
			return;
		}
		for(int i=start;i<list.size();i++) {
			if(!visited[i]) {
				visited[i] = true;
				int[] tmp = list.get(i);
				String str = s.substring(0,tmp[0])+"k"+s.substring(tmp[0]+1,tmp[1])+"k";
				if(tmp[1]!=s.length()-1) {
					str+=s.substring(tmp[1]+1);
				}
				remove(cnt-1,str,i+1);
				visited[i] = false;
			}
		}
	}
}