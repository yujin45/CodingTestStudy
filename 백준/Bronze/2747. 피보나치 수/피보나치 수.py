import sys

input = sys.stdin.readline


def fib(num):
    if dp[num] == -1:  # 한번도 연산된 적이 없다면
        dp[num] = fib(num - 1) + fib(num - 2)
    return dp[num]


num = int(input())
dp = [-1] * 46
dp[0] = 0
dp[1] = 1
print(fib(num))
