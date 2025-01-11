import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(graph, x, y):
    count = 1
    graph[x][y] = 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] == 0:
            count += dfs(graph, nx, ny)

    return count


# m행 n열
m, n, k = map(int, input().split())

graph = [[0] * n for _ in range(m)]

for _ in range(k):
    # 왼 하단, 우 상단
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            graph[i][j] = 1

result_space = []

for i in range(m):
    for j in range(n):
        if graph[i][j] == 0:
            # 빈칸이면 개수 체크
            result_space.append(dfs(graph, i, j))

print(len(result_space))
result_space.sort()
print(' '.join(map(str, result_space)))
