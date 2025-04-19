import sys
input = sys.stdin.readline

def can_install(houses, dist, c):
    count = 1
    last_pos = houses[0]
    for i in range(1, len(houses)):
        if houses[i] - last_pos >= dist:
            count += 1
            last_pos = houses[i]
    return count >= c

n, c = map(int, input().split())
houses = [int(input()) for _ in range(n)]
houses.sort()  # 꼭 정렬해야 합니다!

left = 1  # 최소 거리 후보
right = houses[-1] - houses[0]  # 최대 거리 후보
answer = 0

while left <= right:
    mid = (left + right) // 2
    if can_install(houses, mid, c):
        answer = mid        # 가능하면 저장하고
        left = mid + 1      # 더 큰 거리 탐색
    else:
        right = mid - 1     # 불가능하면 거리 줄이기

print(answer)
