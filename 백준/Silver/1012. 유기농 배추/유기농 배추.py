import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

t = int(input())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(graph, x, y):
    graph[x][y] = 2  # 방문

    for i in range(4):
        nx = x + dx[i]  # 행
        ny = y + dy[i]  # 열
        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
            dfs(graph, nx, ny)


for _ in range(t):
    m, n, k = map(int, input().split())  # 열, 행, 배추 위치 개수

    graph = [[0] * m for _ in range(n)]

    for _ in range(k):
        # 가로 길이 m -> 열, x
        # 세로 길이 n -> 행, y
        x, y = map(int, input().split())
        graph[y][x] = 1

    total_count = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                total_count += 1
                dfs(graph, i, j)
                
    print(total_count)
