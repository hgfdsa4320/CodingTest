import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
		Stack<Character> LSt = new Stack<>();
		Stack<Character> RSt = new Stack<>();
		for(int i=0;i<s.length();i++) {
			LSt.push(s.charAt(i));
		}
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("L")) {
				if(!LSt.isEmpty())
					RSt.push(LSt.pop());	
			}else if(order.equals("D")) {
				if(!RSt.isEmpty())
					LSt.push(RSt.pop());
			}else if(order.equals("B")) {
				if(!LSt.isEmpty())
					LSt.pop();
			}else {
				char c = st.nextToken().charAt(0);
				LSt.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!LSt.isEmpty()) {
			sb.append(LSt.pop());
		}
		sb.reverse();
		while(!RSt.isEmpty()) {
			sb.append(RSt.pop());
		}
		System.out.println(sb);
	}
}