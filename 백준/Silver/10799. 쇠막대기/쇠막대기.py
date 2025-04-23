import sys

input = sys.stdin.readline
#
ps = list(input().strip())
stack = []
count = 0

for i, ch in enumerate(ps):
    if ch == '(':
        stack.append('(')
    else:
        stack.pop()
        if ps[i - 1] == '(':  # 레이저
            count += len(stack)
        else:  # 막대기 끝
            count += 1

print(count)
