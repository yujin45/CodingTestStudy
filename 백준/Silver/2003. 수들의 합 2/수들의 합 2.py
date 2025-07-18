
import sys

input = sys.stdin.readline

# 입력 처리
N, M = map(int, input().split())
arr = list(map(int, input().split()))

# i ~ j 번째 수 합이 M이 되는 경우의 수
count = 0
left = 0
right = 0
sum_ = arr[0]

while True:
    # M보다 작으면 right 늘리고 유효값이면 더해주기
    if sum_ < M:
        right += 1
        if right == N:
            break
        sum_ += arr[right]
    # M이면 left를 이동하고 count
    elif sum_ == M:
        count += 1
        sum_ -= arr[left]
        left += 1
    # M보다 큰 경우에도 left를 이동
    else:
        sum_ -= arr[left]
        left += 1

print(count)