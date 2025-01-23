import sys

input = sys.stdin.readline

n = int(input())
table = [0]

for _ in range(n):
    table.append(int(input()))

# 계단이 1, 2개인 경우
if n == 1:
    print(table[1])
    exit()
elif n == 2:
    print(table[1] + table[2])
    exit()

# dp 배열 초기화
dp = [0] * (n + 1)
dp[1] = table[1]
dp[2] = table[1] + table[2]
dp[3] = max(table[1] + table[3], table[2] + table[3])

# 점화식
for i in range(4, n + 1):
    dp[i] = max(dp[i - 2], dp[i - 3] + table[i - 1]) + table[i]

print(dp[n])
