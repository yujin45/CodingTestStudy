import sys

input = sys.stdin.readline

n = int(input())
ret = list(map(int, input().split()))

ret.sort()
result_sum = 0
for i in range(n):
    result_sum += (ret[i]*(n-i))
print(result_sum)