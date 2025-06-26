class Solution {
     public int solution(int[] money) {
        int n = money.length;
        if (n == 3) {
            return Math.max(Math.max(money[0], money[1]), money[2]);
        }

        return Math.max(rob(money, 0, n - 2), rob(money, 1, n - 1));
    }

    // 일반적인 도둑질 문제 (선형 구조)
    private int rob(int[] money, int start, int end) {
        int[] dp = new int[money.length];
        dp[start] = money[start]; // 첫번째 집만 턴 경우
        // 두번째 집은 = start만 턴경우 or stat+1만 턴 경우 
        dp[start + 1] = Math.max(money[start], money[start + 1]);
        
        for(int i = start+2; i<= end; i++){
            // 선택x, 선택o일 때
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        
        return dp[end];
        
    }
}