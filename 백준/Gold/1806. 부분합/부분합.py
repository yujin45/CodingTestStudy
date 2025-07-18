
import sys

input = sys.stdin.readline

# 입력 처리 
N, S = map(int, input().split())
arr = list(map(int, input().split()))

start, end = 0, 0
total = 0
min_len = N + 1 # 불가능한 최대값으로 초기화

while True:
    if total >= S:
        min_len = min(min_len, end - start)
        total -= arr[start] # start 빼주고 이동
        start += 1
    elif end == N:
        break
    else:
        total += arr[end]
        end += 1
    
print(0 if min_len == N + 1 else min_len)

