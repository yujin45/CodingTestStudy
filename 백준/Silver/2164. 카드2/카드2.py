import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

deque =deque([i for i in range(1, n+1)])
while len(deque)>1:
    # 카드 1장 남을 때까지 반복
    deque.popleft()
    deque.append(deque.popleft())

print(deque[0])