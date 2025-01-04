import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
deque = deque()
ret = []
for _ in range(n):
    command = input().strip()
    if command.startswith("push"):
        _, num = command.split()
        deque.append(num)
    elif command.startswith("pop"):
        if deque:
            ret.append(deque.popleft())
        else:
            ret.append("-1")
    elif command.startswith("size"):
        ret.append(f"{len(deque)}")
    elif command.startswith("empty"):
        if deque:
            ret.append("0")
        else:
            ret.append("1")
    elif command.startswith("front"):
        if deque:
            ret.append(deque[0])
        else:
            ret.append("-1")
    elif command.startswith("back"):
        if deque:
            ret.append(deque[-1])
        else:
            ret.append("-1")

print('\n'.join(ret))