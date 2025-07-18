
import sys

input = sys.stdin.readline

# 입력 처리
n = int(input())
arr = list(map(int, input().split()))
x = int(input())

##
arr.sort()
left, right = 0, n - 1
count = 0

while left < right:
    temp = arr[left] + arr[right]
    if temp == x:
        # 쌍을 찾는 문제라 둘 다 이동
        count += 1
        left += 1
        right -= 1
    elif temp < x:
        left += 1
    else:
        right -= 1

print(count)


