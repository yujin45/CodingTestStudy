// 일단 O(N^2)으로 라도 풀어보기
class Solution {
    public int[] solution(int[] prices) {
        int [] answer = new int [prices.length];
        for(int i =0; i<prices.length; i++){
            int count = 0;
            B:for(int j = i+1; j <prices.length; j++){
                count++;
                if(prices[i] > prices[j]){
                    break B; 
                }
            }
            answer[i]=count;
        }
        return answer;
    }
}