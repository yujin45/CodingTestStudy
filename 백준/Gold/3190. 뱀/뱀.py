from collections import deque
import sys

input = sys.stdin.readline
#
# 우, 하, 좌, 상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
d_idx = 0


def rotate_left_90(d_idx):
    return (d_idx + 1) % 4


def rotate_right_90(d_idx):
    return (d_idx + 3) % 4


N = int(input())
graph = [[0] * N for _ in range(N)]

K = int(input())
for _ in range(K):
    apple_x, apple_y = map(int, input().split())
    graph[apple_x - 1][apple_y - 1] = 1

L = int(input())
directions = deque()
for _ in range(L):
    X, C = input().split()
    directions.append((int(X), C))

snake = deque([(0, 0)])

game = True
time = 0
while game:
    # front가 꼬리 end가 머리
    # 몸 길이를 늘려 머리를 다음 칸에 위치
    head_x, head_y = snake[-1][0], snake[-1][1]
    nx, ny = head_x + dx[d_idx], head_y + dy[d_idx]
    if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] != 2:
        # 사과 체크
        if graph[nx][ny] != 1:
            # 사과 없으면 꼬리 줄여야 함
            tail_x, tail_y = snake.popleft()
            graph[tail_x][tail_y] = 0

        graph[nx][ny] = 2
        snake.append((nx, ny))

    else:
        game = False

    time += 1
    if directions and time == directions[0][0]:
        _, C = directions.popleft()
        if C == 'L':
            d_idx = (d_idx + 3) % 4
        elif C == 'D':
            d_idx = (d_idx + 1) % 4

print(time)
