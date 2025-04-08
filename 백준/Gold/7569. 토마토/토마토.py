import sys
from collections import deque
input = sys.stdin.readline

# 입력 받기
m, n, h = map(int, input().split())
graph = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]

# 6방향 벡터
dz = [0, 0, 0, 0, -1, 1]
dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]

# 익은 토마토들 큐에 넣기
queue = deque()
not_yet = 0
for z in range(h):
    for x in range(n):
        for y in range(m):
            if graph[z][x][y] == 1:
                queue.append((z, x, y))
            elif graph[z][x][y] == 0:
                not_yet += 1

if not_yet == 0:
    print(0)
else:
    # BFS 시작
    while queue:
        cz, cx, cy = queue.popleft()
        for i in range(6):
            nz = cz + dz[i]
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nz < h and 0 <= nx < n and 0 <= ny < m:
                if graph[nz][nx][ny] == 0:
                    graph[nz][nx][ny] = graph[cz][cx][cy] + 1
                    queue.append((nz, nx, ny))

    # 결과 확인
    max_day = 0
    for z in range(h):
        for x in range(n):
            for y in range(m):
                if graph[z][x][y] == 0:
                    print(-1)
                    sys.exit()
                max_day = max(max_day, graph[z][x][y])

    print(max_day - 1)
