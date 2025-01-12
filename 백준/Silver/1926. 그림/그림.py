import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)
directions = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
]

def dfs(graph, x, y):
    count = 1
    graph[x][y] = 2

    for (dx, dy) in directions:
        nx = x + dx
        ny = y + dy
        if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] == 1:
            count += dfs(graph, nx, ny)

    return count


n, m = map(int, input().split())  # 행, 열
graph = [list(map(int, input().split())) for _ in range(n)]

ret = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            ret.append(dfs(graph, i, j))

if ret:
    print(len(ret))
    print(max(ret))
else:
    print(0)
    print(0)
