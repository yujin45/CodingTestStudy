from collections import deque

def bfs(F, S, G, U, D):
    visited = [-1] * (F + 1)  # 층은 1부터 시작, -1은 아직 방문 안 함
    queue = deque()

    queue.append(S)
    visited[S] = 0

    while queue:
        current = queue.popleft()

        # 도착!
        if current == G:
            return visited[current]

        # 위로 이동
        if U > 0:
            up = current + U
            if up <= F and visited[up] == -1:
                visited[up] = visited[current] + 1
                queue.append(up)

        # 아래로 이동
        if D > 0:
            down = current - D
            if down >= 1 and visited[down] == -1:
                visited[down] = visited[current] + 1
                queue.append(down)

    return "use the stairs"

# 입력
F, S, G, U, D = map(int, input().split())
print(bfs(F, S, G, U, D))
