import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs_iterative(graph, x, y, visited, h):
    stack = [(x, y)]
    visited[x][y] = True

    while stack:
        cx, cy = stack.pop()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]):
                if not visited[nx][ny] and graph[nx][ny] > h:
                    visited[nx][ny] = True
                    stack.append((nx, ny))

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

max_val = max(map(max, graph))  # 최대 높이
max_safe = 0

for h in range(0, max_val + 1):  # ✅ 비 높이 0부터 시작
    visited = [[False]*n for _ in range(n)]
    safe_zone = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] > h and not visited[i][j]:
                dfs_iterative(graph, i, j, visited, h)
                safe_zone += 1
    max_safe = max(max_safe, safe_zone)

print(max_safe)
