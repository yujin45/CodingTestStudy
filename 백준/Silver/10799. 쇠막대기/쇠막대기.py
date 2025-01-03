import sys

input = sys.stdin.readline

pipes = input().strip()
stack = []
pieces = 0

for i in range(len(pipes)):
    if pipes[i] == '(':
        stack.append('(')
    else:
        stack.pop()
        if pipes[i-1] == '(': # 레이저
            pieces += len(stack)
        else: # 막대 끝
            pieces +=1 # 막대기 끝 1조각

print(pieces)