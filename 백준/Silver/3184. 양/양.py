import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(graph, x, y):
    global sheep, wolf

    if graph[x][y] == 'o':
        sheep += 1
    elif graph[x][y] == 'v':
        wolf += 1

    graph[x][y] = '#'

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] != '#':
            dfs(graph, nx, ny)


r, c = map(int, input().split())
graph = [list(map(str, input().strip())) for _ in range(r)]

total_sheep = 0
total_wolf = 0
for i in range(r):
    for j in range(c):
        # .만 있는 경우 pass 가능하게 됨
        if graph[i][j] == 'v' or graph[i][j] == 'o':
            sheep = 0
            wolf = 0
            dfs(graph, i, j)
            if sheep > wolf:
                total_sheep += sheep
            else:
                total_wolf += wolf

print(total_sheep, total_wolf)
