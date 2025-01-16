import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

# 0 행에서 마지막 행까지 도달 했는지를 판단해야 함
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(graph, x, y, color, visited):
    count = 1
    visited[x][y] = 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] in color and not visited[nx][ny]:
            visited[nx][ny] = 1
            count += dfs(graph, nx, ny, color, visited)
    return count


# 뭔가 한번에 돌면서 가능할 것 같기도 하지만 잘 모르겠으므로 그냥 전부 탐색 2회 돌아보겠음

n = int(input())
graph = [list(input().strip()) for _ in range(n)]
visited = [[0] * n for _ in range(n)]

# B, R, G, RG
normal_count = 0

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            if graph[i][j] == 'R':
                dfs(graph, i, j, 'R', visited)
            elif graph[i][j] == 'G':
                dfs(graph, i, j, 'G', visited)
            elif graph[i][j] == 'B':
                dfs(graph, i, j, 'B', visited)
            normal_count += 1

visited = [[0] * n for _ in range(n)]
rg_count = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            if graph[i][j] == 'R' or graph[i][j] == 'G':
                dfs(graph, i, j, 'RG', visited)
            elif graph[i][j] == 'B':
                dfs(graph, i, j, 'B', visited)
            rg_count += 1

print(normal_count, rg_count)
