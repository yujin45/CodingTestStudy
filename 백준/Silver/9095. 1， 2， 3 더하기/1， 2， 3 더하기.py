import sys

input = sys.stdin.readline

dp = [0] * 11
dp[1] = 1  # 1을 만드는 방법
dp[2] = 2  # 2를 만드는 방법
dp[3] = 4  # 3을 만드는 방법

for i in range(4, 11):
    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    # 1, 2, 3으로 끝나는 것들 더하기

t = int(input())
for _ in range(t):
    n = int(input())
    print(dp[n])
