import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(graph, x, y, visited):
    visited[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and not visited[nx][ny] and graph[nx][ny] > h:
            dfs(graph, nx, ny, visited)


n = int(input())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

# high = set()
# for i in range(n):
#     for j in range(n):
#         high.add(graph[i][j])

max_high = max(map(max, graph))

max_ret = 1
# 내리는 비의 양을 다 조사
for h in range(max_high):
    # h이하는 잠김 => h 초과인 애들은 안전지대
    visited = [[False] * n for _ in range(n)]
    safe_area = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j] and graph[i][j] > h:
                dfs(graph, i, j, visited)
                safe_area += 1
    max_ret = max(safe_area, max_ret)
print(max_ret)
