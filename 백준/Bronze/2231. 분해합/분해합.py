import sys

input = sys.stdin.readline

n = int(input().strip())


def D_sum(x):
    return x + sum(map(int, str(x)))


result = 0
for candidate in range(max(1, n - len(str(n)) * 9), n):
    if D_sum(candidate) == n:
        result = candidate
        break
print(result)
