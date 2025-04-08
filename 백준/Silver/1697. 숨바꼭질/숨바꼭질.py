import sys
from collections import deque

input = sys.stdin.readline


def bfs(n, k):
    MAX = 100_001  # 0 ~ 100,000
    visited = [-1] * MAX  # -1은 아직 방문 안 함
    queue = deque()

    queue.append(n)  # 시작점
    visited[n] = 0  # 시작 위치는 0초

    while queue:
        current = queue.popleft()

        # 도착하면 바로 종료
        if current == k:
            return visited[current]

        for next_pos in [current - 1, current + 1, current * 2]:
            if 0 <= next_pos < MAX and visited[next_pos] == -1:
                visited[next_pos] = visited[current] + 1
                queue.append(next_pos)


# 입력 
n, k = map(int, input().split())
print(bfs(n, k))
