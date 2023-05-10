import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] nums = new String[numbers.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums,(a,b)->(b+a).compareTo(a+b));
        if(nums[0].equals("0")) return "0";
        for(String s : nums){
            sb.append(s);
        }
        return sb.toString();
    }
}