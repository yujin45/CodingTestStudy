import sys

input = sys.stdin.readline

n = int(input())
dp = [0] + list(map(int, input().split()))

for i in range(1, n + 1):
    for j in range(1, i // 2 + 1):
        dp[i] = max(dp[i], dp[i - j] + dp[j])

print(dp[n])
