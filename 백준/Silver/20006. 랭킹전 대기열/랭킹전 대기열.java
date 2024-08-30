import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1. 플레이어 입장
 * 만약 들어갈 방이 없으면
 * 방을 만든다(방 번호, 레벨 최소, 레벨 최대,방 인원)
 * 방 정보는
 * Map<Integer,int[]> -> 방 번호, {방의 허용 레벨 범위, 인원}
 * List<UserInfo>[] -> 해당 방에 들어가있는 플레이어 정보
 *
 * 플레이어가 처음 들어오면 Map의 크기만큼 돌면서, 들어갈 수 있는 방이 있는지 확인
 * 있으면 리스트에 해당 방번호에만 플레이어 정보 넣고 방 인원 증가
 * 없으면 맵과 리스트에 각각 넣어주기 방인원도 증가
 *
 * 만약 방에 인원이 다 차면?
 *
 */
class UserInfo {
	int level;
	String nickname;

	public UserInfo(int level, String nickname) {
		this.level = level;
		this.nickname = nickname;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<Integer, int[]> roomMap = new HashMap<>();
		List<UserInfo>[] roomList= new ArrayList[p + 1];

		for (int i = 1; i <= p; i++)
			roomList[i] = new ArrayList<>();

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();

			//현재 들어갈 수 있는 방이 있는지 확인
			boolean isPossible = false;
			for (int j = 1; j <= roomMap.size(); j++) {
				int[] info = roomMap.get(j);

				if (l >= info[0] && l <= info[1] && info[2] < m) {
					roomMap.put(j, new int[] {info[0], info[1], info[2] + 1});
					roomList[j].add(new UserInfo(l, n));
					isPossible = true;
					break;
				}
			}
			if (!isPossible) {
				roomMap.put(roomMap.size() + 1, new int[] {l - 10, l + 10, 1});
				roomList[roomMap.size()].add(new UserInfo(l, n));
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= roomMap.size(); i++) {
			if (roomMap.get(i)[2] == m) {
				sb.append("Started!").append("\n");
			} else {
				sb.append("Waiting!").append("\n");
			}
			Collections.sort(roomList[i], (a, b) -> a.nickname.compareTo(b.nickname));
			for (int j = 0; j < roomList[i].size(); j++) {
				sb.append(roomList[i].get(j).level).append(" ").append(roomList[i].get(j).nickname).append("\n");
			}
		}
		System.out.println(sb);
	}
}