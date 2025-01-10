import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def dfs(graph, x, y, n):
    graph[x][y] = -1  # 방문 표시
    global count
    count += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and (graph[nx][ny] == 1):
            dfs(graph, nx, ny, n)


n = int(input())
graph = [list(map(int, input().strip())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
count = 0

home_count = []
for i in range(n):
    for j in range(n):
        # 돌면서 안 돈 곳 있으면 돌아야 함
        if graph[i][j] == 1:
            dfs(graph, i, j, n)
            home_count.append(count)
            count = 0
home_count.sort()
print(len(home_count))
print('\n'.join(map(str, home_count)))
