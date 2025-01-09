import sys
from collections import deque

input = sys.stdin.readline

n, k, m = map(int, input().split())

queue = deque(range(1, n + 1))

isRight = True  # 초기 오른쪽 방향으로 인덱스 검사
ret = []  # 결과 넣어둘 곳
index = 0

while queue:
    # k번째가 되게 회전
    if isRight:
        # 제거된 것 기준 오른쪽이라 이건 그냥 k-1로 해도 됨
        queue.rotate(-((k - 1) % len(queue)))
    else:
        # 제거된 것 기준 왼쪽으로 k번재인데 제거된게 없어서 k로 접근해야 함
        queue.rotate(k % len(queue))

    ret.append(queue.popleft())

    if (len(ret)) % m == 0:
        # m명이 제거되었다면 방향 전환
        isRight = not isRight
print('\n'.join(map(str, ret)))
