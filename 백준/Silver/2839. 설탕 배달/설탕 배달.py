import sys

input = sys.stdin.readline

n = int(input())

dp = [-1] * (n + 1)

for i in range(1, n + 1):
    temp5 = -1
    temp3 = -1
    if i % 5 == 0:
        temp5 = i // 5
    else:
        if dp[i - 5] == -1:
            temp5 = -1
        else:
            temp5 = 1 + dp[i - 5]

    if i % 3 == 0:
        temp3 = i // 3
    else:
        if dp[i - 3] == -1:
            temp3 = -1
        else:
            temp3 = 1 + dp[i - 3]

    if temp3 == -1 and temp5 != -1:
        dp[i] = temp5
    elif temp3 != -1 and temp5 == -1:
        dp[i] = temp3
    elif temp3 == -1 and temp5 == -1:
        dp[i] = -1
    else:
        dp[i] = min(temp3, temp5)

print(dp[n])
