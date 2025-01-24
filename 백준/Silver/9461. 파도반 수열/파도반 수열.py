import sys

input = sys.stdin.readline

T = int(input())
ret = []
# n은 100까지
dp = [0] * 101
dp[1] = 1
dp[2] = 1
for i in range(3, 101):
    dp[i] = dp[i - 3] + dp[i - 2]

for _ in range(T):
    ret.append(dp[int(input())])

print('\n'.join(map(str, ret)))
