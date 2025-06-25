import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
              while(!stack.isEmpty() && prices[stack.peekLast()] > prices[i]){
                    // 떨어진 경우
                    int topIndex = stack.removeLast();
                    result[topIndex] = i - topIndex;
                }
            
            stack.add(i);
        }
        
        while(!stack.isEmpty()){
            int topIndex = stack.removeLast();
            result[topIndex] = prices.length - 1 - topIndex;
        }
        
        return result;
    }
}