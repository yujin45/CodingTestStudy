import java.util.*;

class Solution {
    private int dfs(int current, int target, int[] numbers, int i){
        if(i == numbers.length){
            // 모든 수 다 쓰고 current가 target인지 확인하기
            return current == target ? 1 : 0;
        }
        
        int plus = dfs(current + numbers[i], target, numbers, i+1);
        int minus = dfs(current - numbers[i], target, numbers, i+1);
        return plus + minus;
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(0, target, numbers, 0);
    }
}