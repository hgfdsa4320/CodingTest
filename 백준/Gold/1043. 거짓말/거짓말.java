import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 이야기를 진실을 아는지 모르는지 배열 known
 * 해당 사람이 참가한 파티들을 알려주는 배열 List<Integer>[] parties
 * 해당 파티에 참여한 사람들을 알려주는 배열 List<Integer>[] people
 * 해당 파티가 진실한 이야기를 해야되는 파티인가? 배열 isTrustParty
 * 해당 사람이 이야기의 진실을 아는지 모르는지 배열 known에 정보를 저장한다.
 * 각 파티마다 오는 사람의 수와 번호를 먼저 parties와 people에 저장하고 해당 파티에 진실을 아는 이가 없다면 isTrustParty false를 저장한다.
 * 진실을 아는 이가 있다면, isTrustParty true로 설정하고, 해당 파티에 참가한 사람이 진실을 아는지 확인하고 모른다면 known을 true로 바꿔주고 그 사람이 참여한 모든 파티를 진실한 파티로 바꿔야한다.
 */
public class Main {
	static List<Integer>[] parties;
	static List<Integer>[] people;
	static boolean[] known;
	static boolean[] isTrustParty;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parties = new ArrayList[N + 1];
		people = new ArrayList[M + 1];
		for (int i = 1; i <= N; i++) {
			parties[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			people[i] = new ArrayList<>();
		}
		known = new boolean[N + 1];
		isTrustParty = new boolean[M + 1];
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			known[Integer.parseInt(st.nextToken())] = true;
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int person = Integer.parseInt(st.nextToken());
				parties[person].add(i);
				people[i].add(person);
			}
			if(isKnown(i)){
				isTrustParty[i] = true;
				changeInform(i);
			}
		}
		int cnt = 0;
		for (int i = 1; i <= M; i++) {
			if (!isTrustParty[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static boolean isKnown(int party) {
		for (int i = 0; i < people[party].size(); i++) {
			if (known[people[party].get(i)]) {
				return true;
			}
		}
		return false;
	}

	static void changeInform(int party) {
		for (int i = 0; i < people[party].size(); i++) {
			int p = people[party].get(i);
			if (!known[p]) {
				known[p] = true;
				for (int j = 0; j < parties[p].size(); j++) {
					int partyNum = parties[p].get(j);
					if (!isTrustParty[partyNum]) {
						isTrustParty[partyNum] = true;
						changeInform(partyNum);
					}
				}
			}
		}
	}
}