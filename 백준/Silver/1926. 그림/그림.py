import sys
from collections import deque

input = sys.stdin.readline

directions = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
]


def bfs(graph, x, y):
    queue = deque([(x, y)])
    graph[x][y] = 2  # 방문 표시
    count = 1
    while queue:
        cx, cy = queue.popleft()
        for (dx, dy) in directions:
            nx = cx + dx
            ny = cy + dy
            if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] == 1:
                queue.append((nx, ny))
                graph[nx][ny] = 2
                count += 1
    return count


n, m = map(int, input().split())  # 행, 열
graph = [list(map(int, input().split())) for _ in range(n)]

ret_count = 0
ret_max = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            ret_max = max(ret_max, bfs(graph, i, j))
            ret_count += 1
print(ret_count)
print(ret_max)
