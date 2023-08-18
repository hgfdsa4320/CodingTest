import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=0;i<n;i++) {
			Stack<Character> st = new Stack<>();
			String s = br.readLine();
			if(s.length()%2==1) continue;
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				if(!st.empty() && st.peek()==c) {
					st.pop();
				}else {
					st.push(c);
				}
			}
			if(st.isEmpty()) answer++; 
		}
		System.out.println(answer);
	}
}