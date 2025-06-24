import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (a, b) -> (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        for(String num : nums){
            sb.append(num);
        }
        
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}