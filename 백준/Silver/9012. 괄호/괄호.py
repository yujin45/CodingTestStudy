import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
stack = deque()
flag = False
for _ in range(n):
    input_list = input().strip()
    for ps in input_list:
        if ps == '(':
            stack.append(ps)
        elif ps == ')':
            if not stack:
                # 비어 있으면 바로 return
                flag = True
                break
            if stack[-1] == '(':
                stack.pop()
            else:
                stack.append(ps)

    if len(stack) > 0 or flag:
        print("NO")
        stack.clear()
        flag = False
    else:
        print("YES")

