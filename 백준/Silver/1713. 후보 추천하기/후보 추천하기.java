import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Student{
	int no; // 학생 번호
	int cnt; // 추천받은 수
	int time; // 게시판에 게시된 시간

	public Student(int no, int cnt,int time) {
		this.no = no;
		this.cnt = cnt;
		this.time = time;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//첫째 줄에는 사진틀의 개수 N이 주어진다. (1 ≤ N ≤ 20)
		int N = Integer.parseInt(br.readLine());
		// 둘째 줄에는 전체 학생의 총 추천 횟수가 주어지고,
		int M = Integer.parseInt(br.readLine());
		// 셋째 줄에는 추천받은 학생을 나타내는 번호가 빈 칸을 사이에 두고 추천받은 순서대로 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 총 추천 횟수는 1,000번 이하이며 학생을 나타내는 번호는 1부터 100까지의 자연수이다.

		//학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
		// 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고, 그 자리에 새롭게 추천받은 학생의 사진을 게시한다.
		// 이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
		List<Student> studentList = new ArrayList<>();
		Set<Integer> set = new HashSet<>(); // 현재 누가 있는지
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 현재 사진틀에 해당 후보가 없는 경우
			if (!set.contains(num)) {
				// 현재 사진틀이 꽉 찬 경우
				if (studentList.size() == N) {
					Collections.sort(studentList, (a, b) -> a.cnt == b.cnt ? a.time - b.time : a.cnt - b.cnt);
					int deleteNum = studentList.get(0).no;
					studentList.remove(0);
					set.remove(deleteNum);
				}
				studentList.add(new Student(num, 1, i));
				set.add(num);
			} else { // 현재 사진틀에 해당 후보가 있는 경우
				for (int j = 0; j < studentList.size(); j++) {
					Student s = studentList.get(j);
				// 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
					if (s.no == num) {
						s.cnt++;
						break;
					}
				}
			}
		}
		//사진틀에 사진이 게재된 최종 후보의 학생 번호를 증가하는 순서대로 출력한다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < studentList.size(); i++) {
			pq.offer(studentList.get(i).no);
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll() + " ");
		}
		System.out.println(sb);
		// 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
		// 사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.
		// 후보의 수 즉, 사진틀의 개수와 전체 학생의 추천 결과가 추천받은 순서대로 주어졌을 때, 최종 후보가 누구인지 결정하는 프로그램을 작성하시오.

	}
}