import sys

input = sys.stdin.readline
#
from collections import deque


def menhattan_dist(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])


def bfs(locations, n):
    visited = [False] * (n + 2)
    queue = deque()
    queue.append(0)  # 시작점 인덱스
    visited[0] = True

    while queue:
        current = queue.popleft()

        # 도착점이면 happy
        if current == n + 1:
            return "happy"

        for next in range(n + 2):
            if not visited[next] and menhattan_dist(locations[current], locations[next]) <= 1000:
                visited[next] = True
                queue.append(next)

    return "sad"

# 입력 처리
t = int(input())
for _ in range(t):
    n = int(input())  # 편의점 개수
    locations = [tuple(map(int, input().split())) for _ in range(n + 2)]  # 출발지, n개 편의점, 도착지
    print(bfs(locations, n))
