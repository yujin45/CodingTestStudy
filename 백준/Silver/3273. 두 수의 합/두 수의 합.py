
import sys

input = sys.stdin.readline

# 입력 처리
n = int(input())
arr = list(map(int, input().split()))
x = int(input())

##
seen = set()
count = 0

for num in arr:
    if x - num in seen:
        count += 1
    seen.add(num)

print(count)


