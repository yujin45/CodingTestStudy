import sys

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def print_graph(graph, now_count, now_group):
    print("============================")
    print(f"현재 빙하 영역 개수 : {now_count} - 덩어리 개수 : {now_group}")
    for i in range(len(graph)):
        print(graph[i])


def melt_ice(graph, n, m):
    temp_graph = [[0] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if graph[i][j] > 0:
                # 4방향 체크
                ocean = 0
                for k in range(4):
                    if graph[i + dx[k]][j + dy[k]] == 0:
                        ocean += 1
                temp_graph[i][j] = max(0, graph[i][j] - ocean)

    return temp_graph

def count_ice(graph, n, m):
    ice =0
    for i in range(n):
        for j in range(m):
            if graph[i][j] > 0:
                ice+=1
    return ice

def dfs(graph, n, m, x, y, visited):
    stack = [(x, y)]
    visited[x][y] = True

    while stack:
        cx, cy = stack.pop()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and graph[nx][ny] > 0:
                visited[nx][ny] = True
                stack.append((nx, ny))


def count_group(graph, n, m):
    visited = [[False] * m for _ in range(n)]
    group = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] > 0 and not visited[i][j]:
                dfs(graph, n, m, i, j, visited)
                group += 1
    return group


# 입력
n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
#

time = 0  # 흐르는 시간
now_count = 0  # 빙하 개수 체크용도
now_group = 0  # 현재 빙하 덩어리 개수

# 최초의 빙하 개수 구하기
now_count = count_ice(graph, n, m)

while True:
    now_group = count_group(graph, n, m)

    if now_group >= 2:
        print(time)
        break

    now_count = count_ice(graph, n, m)
    if now_count <= 0:
        print(0)
        break

    graph = melt_ice(graph, n, m)
    time += 1