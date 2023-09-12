import java.io.*;
import java.util.Arrays;
import java.util.*;

public class Main {
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] nums = new boolean[4000001];
		Arrays.fill(nums, true);
		nums[1] = false;
		answer = 0;
		for (int i = 2; i <= n; i++) {
			if (!nums[i])
				continue;
			for (int j = i + i; j <= n; j += i) {
				nums[j] = false;
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (nums[i])
				list.add(i);
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		if (list.size() > 0) {
			sum = list.get(end);
		}

		while (end < list.size() && start <= end) {
			if (sum == n) {
				answer++;
				if (end == list.size() - 1)
					break;
				sum = sum + list.get(++end) - list.get(start++);
			} else if (sum < n) {
				if (end == list.size() - 1)
					break;
				sum += list.get(++end);
			} else {
				sum -= list.get(start++);
			}
		}
		System.out.println(answer);
	}
}