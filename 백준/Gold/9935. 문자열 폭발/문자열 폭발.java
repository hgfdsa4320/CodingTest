import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bomb = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		char lastStr = bomb.charAt(bomb.length() - 1);
		for (int i = 0; i < s.length(); i++) {
			st.push(s.charAt(i));
			if (st.size() >= bomb.length() && s.charAt(i) == lastStr) {
				Stack<Character> tmpSt = new Stack<>();
				boolean flag = true;

				for (int j = bomb.length() - 1; j >= 0; j--) {
					if (st.peek() == bomb.charAt(j)) {
						tmpSt.push(st.pop());

					} else {
						flag = false;
						break;
					}
				}
				if (!flag) {
					while (!tmpSt.isEmpty()) {
						st.push(tmpSt.pop());
					}
				}
			}
		}
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		sb.reverse();
		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);
		}
	}
}