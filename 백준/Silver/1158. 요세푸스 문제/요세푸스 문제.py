import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
deque = deque([i for i in range(1, n+1)])

ret = []
i=0
while deque:
    i += 1
    if i%k==0:
        ret.append(deque.popleft())
    else:
        deque.append(deque.popleft())

print("<" + ", ".join(map(str, ret))+">")