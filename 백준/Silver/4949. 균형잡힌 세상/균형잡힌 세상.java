import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * So when I die (the [first] I will see in (heaven) is a score list).
 * [ first in ] ( first out ).
 * Half Moon tonight (At least it is better than no Moon at all].
 * A rope may form )( a trail in a maze.
 * Help( I[m being held prisoner in a fortune cookie factory)].
 * ([ (([( [ ] ) ( ) (( ))] )) ]).
 *  .
 * .
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			boolean isCollect = true;
			String s = br.readLine();
			if (s.equals(".")) {
				break;
			}
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ']') {
					if (st.isEmpty() || st.pop() != '[') {
						isCollect = false;
						break;
					}
				} else if (s.charAt(i) == ')') {
					if (st.isEmpty() || st.pop() != '(') {
						isCollect = false;
						break;
					}
				} else if (s.charAt(i) == '[' || s.charAt(i) == '(') {
					st.push(s.charAt(i));
				}
			}
			System.out.println(isCollect && st.isEmpty() ? "yes" : "no");
		}

	}
}