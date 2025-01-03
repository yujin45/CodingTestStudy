import sys

input = sys.stdin.readline


pipes = input().strip()
stack = []
ret = 0
flag = True
for i in range(len(pipes)):
    if pipes[i] == '(':
       stack.append(pipes[i])
       flag = True
    elif pipes[i] == ')':
        if stack[-1] == '(' and flag==True:
            # 자를 때
            stack.pop()
            flag = False
            ret += len(stack)
        else:
            # 닫을 때
            ret+=1
            stack.pop()

print(ret)