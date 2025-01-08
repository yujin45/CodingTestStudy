import sys
from collections import deque

input = sys.stdin.readline

n = int(input())  # 1~n 정수 카드

command = list(map(int, input().split()))
ret = deque()
for card in range(1, n + 1):
    cmd = command.pop()
    if cmd == 1:
        ret.appendleft(card)
    elif cmd == 2:
        ret.insert(1, card)
    elif cmd == 3:
        ret.append(card)

print(' '.join(map(str, ret)))
