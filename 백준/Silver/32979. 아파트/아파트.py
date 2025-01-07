import sys
from collections import deque
input = sys.stdin.readline

n = int(input())  # 참가자 수
t = int(input())  # 아파트 게임 횟수
# 1 ~ n번 참가자 두 손 층층 아파트
apt = list(map(int, input().split()))
# t개의 양의 정수 b
b_nums = list(map(int, input().split()))

queue = deque(apt)
ret = []
for b in b_nums:
    # 1판
    for _ in range(b-1):
        queue.append(queue.popleft())
    ret.append(queue[0])

print(' '.join(map(str, ret)))