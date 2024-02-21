import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		boolean[] isPrime = new boolean[(int)Math.sqrt(max)+1];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
			if(!isPrime[i]) continue;
			for (int j = i + i; j < isPrime.length; j += i) {
				isPrime[j] = false;
			}
		}
		List<Long> list = new ArrayList<>();
		for (int i = 2; i < isPrime.length; i++) {
			if(isPrime[i])
				list.add((long)Math.pow(i,2));
		}

		
		boolean[] arr = new boolean[(int)(max - min) + 1];
		Arrays.fill(arr, true);
		for (int i = 0; i < list.size(); i++) {
			long now = list.get(i);
			long start = min % now == 0 ? min : now - (min % now) + min;
			for (long j = start; j <= max; j += now) {
				arr[(int)(j-min)] = false;
			}
		}
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);


	}
}