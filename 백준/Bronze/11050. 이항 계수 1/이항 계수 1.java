import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int answer = findNum(n, k);
		System.out.println(answer);
	}

	static int findNum(int n, int k) {
		if (k == 1)
			return n;
		if (k == n || k == 0)
			return 1;
		return findNum(n - 1, k - 1) + findNum(n - 1, k);
	}
}