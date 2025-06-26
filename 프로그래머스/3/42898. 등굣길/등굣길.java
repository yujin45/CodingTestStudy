class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 특정 좌표 i, j에 도달할 수 있는 경우의 수 
        // dp[i][j] = dp[i-1][j] + dp[i][j-1] 
        
        int MOD = 1_000_000_007;
        int[][] dp = new int[n+1][m+1];
        
        // 물에 잠긴 지역 표시
        boolean[][] isPuddle = new boolean[n+1][m+1];
        for(int[] puddle: puddles){
            isPuddle[puddle[1]][puddle[0]] = true; // y, x 순서
        }
        
        dp[1][1] = 1; // 시작점
        
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=m; j++){
                if(i==1 && j==1) continue; // 시작점
                if(isPuddle[i][j]){
                    dp[i][j] = 0; /// 물웅덩이라 못지나감
                }else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD; // 위에서 온 것 + 왼쪽에서 온 것
                }
            }
        }
        
        return dp[n][m];
    }
}