import java.util.*;

class Job {
    int start;
    int remain;

    public Job(int start, int remain) {
        this.start = start;
        this.remain = remain;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> a.remain == b.remain ? a.start - b.start : a.remain - b.remain);
        int totalTime = 0;
        int time = 0;
        int idx = 0;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        while (!pq.isEmpty() || idx < jobs.length) {
            // 현재 시간까지 요청된 작업을 모두 pq에 추가
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            // 작업이 없으면 다음 작업 시간으로 점프
            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                // 가장 소요시간이 짧은 작업을 선택
                Job j = pq.poll();
                time += j.remain;
                totalTime += time - j.start;
            }
        }

        return totalTime / jobs.length;
    }
}
