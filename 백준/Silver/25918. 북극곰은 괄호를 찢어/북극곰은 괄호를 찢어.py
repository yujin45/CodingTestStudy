import sys

input = sys.stdin.readline

n = int(input())
s = input().strip()

if s.count(')') != s.count('('):
    print(-1)
    exit()

max_depth = 0
stack = []

# 몇번 감싸져 있느냐가 핵심!! (()) 이건 2일 (())() 이것도 2일
# 즉 stack에 최대 얼마나 쌓이냐를 측정해주면 됨 (( 2일 쌓이는 것이 되기 때문
for c in s:
    if c == '(':
        if stack and stack[-1] == ')':
            stack.pop()
        else:
            stack.append(c)
    elif c == ')':
        if stack and stack[-1] =='(':
            stack.pop()
        else:
            stack.append(c)
    #print(stack)
    max_depth=max(len(stack), max_depth)
    #print(max_depth)
if stack:
    print(-1)
else:
    print(max_depth)