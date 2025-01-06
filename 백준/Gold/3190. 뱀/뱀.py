import sys
from collections import deque

input = sys.stdin.readline

# 0,0 시작
# 길이 1
# 오른쪽 향함
# 몸 길이 늘려서 다음 칸
# 벽, 자신 몸 게임 끝
# 사과 있으면 꼬리 움직이지x 없으면 몸길이 변하지 않고 꼬리 이동
# 뱀 자체가 큐가 되는 느낌
# 사과 위치, 뱀 이동 경로 몇초

n = int(input())
k = int(input())
# 보드 nxn
board = [[0]*n for _ in range(n)]

# print("board 초기화 ---------")
# def print_board(board):
#     for b in board:
#         print(b)
#     print("=====================")
# print_board(board)

for _ in range(k):
    i, j = map(int, input().split())
    board[i-1][j-1] = 1

# print("사과 위치 표시 ---------")
# print_board(board)


L = int(input()) # 방향 변환 횟수

cx, cy = 0, 0 # 초기 위치
dx, dy = 0, 1 # 우측 방향
bam = deque([(0,0)])
board[0][0] = 2
time = 0
for _ in range(L):
    X, C = map(str, input().split())

    while(time<int(X)):
        # time이 X가 되면 방향 전환
        time+=1
        # 이동
        nx = cx + dx
        ny = cy + dy

        if 0<= nx <n and 0<= ny <n and board[nx][ny] != 2:
            # 범위 내 & 자기 자신 아니면 머리 이동
            cx, cy = nx, ny
            if board[nx][ny] != 1:
                # 사과 없으면 꼬리 줄여야 함
                bx, by = bam.popleft()
                board[bx][by] = 0
            bam.append((cx, cy))
            board[cx][cy] = 2


        else:
            # 게임 오버
            print(time)
            exit()
        # print(time)
        # print(nx, ny)
        # print_board(board)
    # X 초 지나고서 회전
    if C == 'D': # 우회전
        dx, dy = dy, -dx
    elif C == 'L': # 좌회전
        dx, dy = -dy, dx

    # print_board(board)

while(True):
        # time이 X가 되면 방향 전환
        time+=1
        # 이동
        nx = cx + dx
        ny = cy + dy

        if 0<= nx <n and 0<= ny <n and board[nx][ny] != 2:
            # 범위 내 & 자기 자신 아니면 머리 이동
            cx, cy = nx, ny
            if board[nx][ny] != 1:
                # 사과 없으면 꼬리 줄여야 함
                bx, by = bam.popleft()
                board[bx][by] = 0
            bam.append((cx, cy))
            board[cx][cy] = 2


        else:
            # 게임 오버
            print(time)
            exit()
        # print(time)
        # print(nx, ny)
        # print_board(board)
