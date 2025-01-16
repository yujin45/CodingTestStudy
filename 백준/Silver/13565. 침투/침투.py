import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

# 0 행에서 마지막 행까지 도달 했는지를 판단해야 함
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(graph, x, y):
    isYes = False
    graph[x][y] = 1  # 방문 표시
    if x == len(graph) - 1:
        # 최하단 도달
        return True

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] == 0:
            graph[nx][ny] = 1
            if not isYes:
                isYes = dfs(graph, nx, ny)

    return isYes


m, n = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(m)]

if 0 not in graph[0]:
    print("NO")
    exit()

for j in range(n):
    if graph[0][j] == 0:
        if dfs(graph, 0, j):
            print("YES")
            exit()
print("NO")
