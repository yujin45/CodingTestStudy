import sys

input = sys.stdin.readline

n = int(input())

# R G B
# 최소값
user_input = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * 3 for _ in range(n)]
# 첫줄 초기화
for i in range(3):
    dp[0][i] = user_input[0][i]

for i in range(1, n):
    for j in range(3):
        if j == 0:  # R
            dp[i][j] = min(dp[i - 1][1], dp[i - 1][2]) + user_input[i][j]
        elif j == 1:  # G 0 2
            dp[i][j] = min(dp[i - 1][0], dp[i - 1][2]) + user_input[i][j]
        elif j == 2:  # B 1 0
            dp[i][j] = min(dp[i - 1][0], dp[i - 1][1]) + user_input[i][j]

# print(dp)
print(min(dp[n - 1]))
