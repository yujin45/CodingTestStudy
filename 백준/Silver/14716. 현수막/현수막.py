import sys
from collections import deque

input = sys.stdin.readline

directions = [
    (-1, -1), (-1, 0), (-1, 1),
    (0, -1), (0, 1),
    (1, -1), (1, 0), (1, 1)
]


def bfs(graph, x, y):
    queue = deque([(x, y)])
    graph[x][y] = 2  # 방문 표시
    while queue:
        cx, cy = queue.popleft()
        for (dx, dy) in directions:
            nx = cx + dx
            ny = cy + dy
            if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] == 1:
                queue.append((nx, ny))
                graph[nx][ny] = 2


# 행 m, 열 n
m, n = map(int, input().split())
graph = []
for _ in range(m):
    graph.append(list(map(int, input().split())))

count = 0
for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            bfs(graph, i, j)
            count += 1

print(count)
