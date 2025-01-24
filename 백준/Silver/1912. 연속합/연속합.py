import sys

input = sys.stdin.readline

n = int(input())
user_input = list(map(int, input().split()))

dp = [0] * n
dp[0] = user_input[0]
max_num = dp[0]
for i in range(1, n):
    dp[i] = max(dp[i - 1] + user_input[i], user_input[i])
    max_num = max(max_num, dp[i])
print(max_num)
