import sys
from collections import deque

input = sys.stdin.readline

directions = [
    (-1, 0),
    (1, 0),
    (0, -1),
    (0, 1)
]


def bfs(graph, start_x, start_y):
    sheep = 0
    wolf = 0
    queue = deque([(start_x, start_y)])
    if graph[start_x][start_y] == 'v':
        # 늑대
        wolf += 1
    elif graph[start_x][start_y] == 'o':
        # 양
        sheep += 1
    graph[start_x][start_y] = '#'

    while queue:
        cx, cy = queue.popleft()

        for (dx, dy) in directions:
            nx = cx + dx
            ny = cy + dy
            if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and graph[nx][ny] != '#':
                queue.append((nx, ny))
                if graph[nx][ny] == 'v':
                    # 늑대
                    wolf += 1
                elif graph[nx][ny] == 'o':
                    # 양
                    sheep += 1
                graph[nx][ny] = '#'
            elif nx < 0 or nx >= len(graph) or ny < 0 or ny >= len(graph[0]):
                return 0, 0
    if wolf >= sheep:
        return 0, wolf
    elif wolf < sheep:
        return sheep, 0


r, c = map(int, input().split())  # 행 열

graph = [list(map(str, input().strip())) for _ in range(r)]

total_wolf = 0
total_sheep = 0
for i in range(r):
    for j in range(c):
        if graph[i][j] == 'o' or graph[i][j] == 'v':
            sheep, wolf = bfs(graph, i, j)
            total_wolf += wolf
            total_sheep += sheep
print(total_sheep, total_wolf)
