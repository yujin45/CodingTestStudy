import sys

input = sys.stdin.readline


def dfs(graph, x, y, direction):
    count = 1
    graph[x][y] = 'X'

    for dx, dy in direction:
        nx = x + dx
        ny = y + dy
        if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] == '.':
            count += dfs(graph, nx, ny, direction)

    return count


n = int(input())
graph_w = [list(input().strip()) for _ in range(n)]
graph_h = []

for i in range(n):
    temp = []
    for j in range(n):
        temp.append(graph_w[i][j])
    graph_h.append(temp)

direction_w = [(0, -1), (0, 1)]  # 가로 방향
direction_h = [(-1, 0), (1, 0)]  # 세로 방향
sleep_w, sleep_h = 0, 0
for i in range(n):
    for j in range(n):
        if graph_w[i][j] == '.':
            if dfs(graph_w, i, j, direction_w) >= 2:
                sleep_w += 1
       
        if graph_h[i][j] == '.':
            if dfs(graph_h, i, j, direction_h) >= 2:
                sleep_h += 1

print(sleep_w, sleep_h)
