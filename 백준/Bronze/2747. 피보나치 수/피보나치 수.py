import sys

input = sys.stdin.readline
num = int(input())
# n은 45보다 작거나 같은 자연수
dp = [0] * 46
dp[1] = 1
dp[2] = 1
for i in range(3, num + 1):
    dp[i] = dp[i - 1] + dp[i -2]

print(dp[num])
