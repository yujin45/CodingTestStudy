import sys
from collections import deque

input = sys.stdin.readline


def bfs(F, S, G, U, D):
    if S == G:
        return 0  # 시작 = 도착이면 바로 0 반환
    visited = [-1] * (F+1) # F층까지 도달 최소 횟수
    visited[S] = 0
    queue = deque([S])

    while queue:
        current = queue.popleft()
        if current == G:
            # 도달했다면 나오기
            return visited[current]
        for next_pos in [current + U, current - D]:
            if 1 <= next_pos <= F and visited[next_pos] == -1:
                visited[next_pos] = visited[current] + 1
                queue.append(next_pos)

    return "use the stairs" # 도달 못했을 경우



# 입력
F, S, G, U, D = map(int, input().split())
print(bfs(F, S, G, U, D))
