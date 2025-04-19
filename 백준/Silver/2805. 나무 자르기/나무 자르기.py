import sys
input = sys.stdin.readline
#

N, M = map(int, input().split())
height = list(map(int, input().split()))
# 높이의 합은 항상 M보다 크거나 같다.
# → 이진 탐색은 절단기 높이에 대해 하니까, 나무 높이 순서는 중요하지 않음

left = 0
right = max(height)
answer = 0

while left <= right:
    mid = (left + right) // 2
    cut = sum(h - mid for h in height if h > mid)

    if cut >= M:
        # 적어도 M 가져가야함
        answer = mid # 일단 저장하고
        left = mid + 1 # 더 높은 곳 가능한지 탐색
    elif cut < M:
        # M 보다 작으면 낮춰야 함 - MID 왼쪽 탐색
        right = mid - 1


print(answer)