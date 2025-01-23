import sys

input = sys.stdin.readline

n = int(input())

t_table = []
p_table = []
t_table.append(0)
p_table.append(0)
dp = [0] * (n + 2)
for _ in range(n):
    t, p = map(int, input().split())
    t_table.append(t)
    p_table.append(p)

for i in range(n, 0, -1):
    if (i + t_table[i] - 1) <= n:
        dp[i] = max(dp[i + 1], dp[i + t_table[i]] + p_table[i])
    else:
        dp[i] = dp[i + 1]

print(dp[1])
