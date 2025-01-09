import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())

queue = deque(range(1, n + 1))

while len(queue) > 1:
    # 1마리 남을 때까지 제거
    if len(queue) <= k:
        # 현재 n마리가 k마리보다 적으면 첫번쩨 제외 모든 청설모 제거 => 첫번째가 답이 됨
        print(queue[0])
        break

    # 시계방향으로 현재 것은 뒤로 넘기기
    queue.append(queue.popleft())  # 첫번째 이후
    # 2~k번째들 제거 (k-1)마리 제거
    for _ in range(k - 1):
        queue.popleft()
