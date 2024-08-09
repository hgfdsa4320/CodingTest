import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 첫 번째 줄에는 회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c가 각각 하나의 빈 칸을 사이에 두고 주어진다.
 * 단, 2 ≤ N ≤ 30,000, 2 ≤ d ≤ 3,000, 2 ≤ k ≤ 3,000 (k ≤ N), 1 ≤ c ≤ d이다.
 * 두 번째 줄부터 N개의 줄에는 벨트의 한 위치부터 시작하여 회전 방향을 따라갈 때 초밥의 종류를 나타내는 1 이상 d 이하의 정수가 각 줄마다 하나씩 주어진다.
 * 슬라이딩 윈도우
 * int[] arr = new int[d+1] -> 윈도우
 * int cnt -> 음식 가짓수
 * 초기에 for문으로 k번만큼 슬라이딩 윈도우 초기화
 * 그 다음 arr[left]==1이면 cnt-1해주고
 * 1보다 크면 1빼주기
 * arr[right]==0이면 cnt+1 아니면 arr[right]++
 * cnt값 확인 최대값인지 -> arr[c]==0이라면 cnt++
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int[] nums = new int[N + k - 1];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N + k - 1; i++) {
			nums[i] = nums[i - N];
		}
		int[] arr = new int[d + 1];
		for (int i = 0; i < k; i++) {
			int now = nums[i];
			arr[now]++;
			if (arr[now] == 1) {
				cnt++;
			}
		}
		int left = 0;
		int right = k - 1;
		int answer = arr[c] == 0 ? cnt + 1 : cnt;
		for (int i = k; i < N + k - 1; i++) {
			arr[nums[left]]--;
			if (arr[nums[left]] == 0) {
				cnt--;
			}
			left++;
			right++;
			arr[nums[right]]++;
			if (arr[nums[right]] == 1) {
				cnt++;
			}
			answer = Math.max(answer, arr[c] == 0 ? cnt + 1 : cnt);
		}
		System.out.println(answer);
	}
}