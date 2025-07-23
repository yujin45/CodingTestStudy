def solution(m, n, puddles):
    # n행 m열 puddle 좌표 주의
    dp = [[0] * m for _ in range(n)]
    for j, i in puddles:
        dp[i-1][j-1] = -1 # 물에 잠긴 곳
        
    # 도착점 m, n => (n-1, m-1) 좌표
    
    # 오른쪽, 아래로만 이동 가능
    # 위에서 온 것과 왼쪽에서 온 것 중 더 작은 값을 유지
    # DP 테이블 체우기
    MOD = 1_000_000_007
    for i in range(n):
        for j in range(m):
            if dp[i][j] == -1:
                dp[i][j] = 0 # 갈 수 없는 곳은 경로 수 0
            elif i == 0 and j == 0:
                dp[i][j] = 1 # 시작점
            else:
                # 현재 위치 i, j에 오는 모든 경우의 수 = 위에서 온 것 + 왼쪽에서 온 것
                if i > 0:
                    dp[i][j] += dp[i-1][j] # 위에서 온 것
                if j > 0:
                    dp[i][j] += dp[i][j-1] # 왼쪽에서 온 것
                
                dp[i][j] %= MOD
    
    return dp[n-1][m-1]