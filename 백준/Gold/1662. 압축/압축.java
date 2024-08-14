import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 압축되지 않은 문자열 S가 주어졌을 때, 이 문자열중 어떤 부분 문자열은 K(Q)와 같이 압축 할 수 있다.
 * K는 한자리 정수이고, Q는 0자리 이상의 문자열이다. 이 Q라는 문자열이 K번 반복된다는 뜻이다.
 * 압축된 문자열이 주어졌을 때, 이 문자열을 다시 압축을 푸는 프로그램을 작성하시오.
 *
 * int 반환하는 함수 findLen(String s)
 *	int openIdx = s.indexOf("(")
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(findLen(s));
	}

	static int findLen(String s) {
		if(s==null)
			return 0;
		int openIdx = s.indexOf("(");
		if (openIdx == -1) {
			return s.length();
		}
		int count = 1;
		for (int i = openIdx + 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
				if (count == 0) { // 열린괄호가 모두 닫힌다면
					//만약 괄호가 빈괄호일 경우
					// 괄호 열리기 전까지 길이 + 괄호 닫히고 나머지 길이
					if (i == openIdx + 1) {
						return openIdx - 1 + (i + 1 == s.length() ? 0 : findLen(s.substring(i + 1)));
					}
					// 괄호 열리기 전까지 길이 + K * Q + 괄호 닫히고 나머지 길이
					return openIdx - 1 + (s.charAt(openIdx - 1) - '0') * findLen(s.substring(openIdx + 1, i)) + ((i + 1)
						== s.length() ?
						0 : findLen(s.substring(i + 1)));
				}
			}
		}
		return 0;
	}
}
/**
 * 33(562(71(9)))11
 * findLen( 33(562(71(9)))11 )
 * int openIdx = indexOf("(")
 * openIdx-1+
 * 1 + 3 * findLen(   562(71(9)) ) + 2
 * 1 + 3 * (  2+2 * findLen(  71(9)   )) + 2
 * 1 + 3 * (  2+2 * (  1 + 1* findLen(	9	)   ) + 2
 * 1 + 3 * (  2+4) + 2
 *
 *
 * 1()66(5)
 *
 * ()
 * 1 * findLen(  ) + findLen(66(5))
 * now
 * 33(562(7)
 *
 *
**/