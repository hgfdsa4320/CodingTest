import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int answer = 0;
        while(left<=right){
            int weight = people[right--];
            if(left<=right && weight+people[left]<=limit){
                left++;
            }
            answer++;
        }
        return answer;
    }
}