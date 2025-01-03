import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
deque = deque(range(1, n+1))
ret = []
while deque:
    ret.append(deque.popleft()) # 버리기
    if deque:
        temp = deque.popleft() # 위의 것 뽑아서
        deque.append(temp) # 제일 아래로 두기
    #print(ret, deque)
print(' '.join(map(str, ret)))