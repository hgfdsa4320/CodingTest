import java.util.*;

class Solution {
    
    static int findRemovals(int[] rocks, int minDist, int distance) {
        int now = 0;  // 현재 위치
        int removals = 0;  // 제거할 돌의 수
        
        for (int rock : rocks) {
            int diff = rock - now;
            if (diff < minDist) {
                removals++;  // 최소 거리보다 작으면 돌 제거
            } else {
                now = rock;  // 최소 거리 이상이면 현재 위치 갱신
            }
        }
        
        // 마지막 돌과 도착지 사이 거리 확인
        if (distance - now < minDist) {
            removals++;
        }
        
        return removals;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);  // 돌을 오름차순 정렬
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int removals = findRemovals(rocks, mid, distance);
            
            if (removals <= n) {
                answer = mid;  // 현재의 mid가 최소 거리로 가능한 경우 갱신
                left = mid + 1;  // 최소 거리를 늘려보기 위해 left 증가
            } else {
                right = mid - 1;  // 돌을 너무 많이 제거했으면 거리 감소
            }
        }
        
        return answer;
    }
}
