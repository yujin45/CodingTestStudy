import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) n * Arrays.stream(times).max().getAsInt();
        long answer = right;
        
        while(left<=right){
            long mid = (left + right) / 2; // 끝낼 시간
            long count = 0;
            for(int time : times){
                count += mid / (long) time;
            }
            if(count >= n){ // 시간 더 줄여봐도 됨
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
}