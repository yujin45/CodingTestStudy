import sys
input = sys.stdin.readline

n = int(input())

stack = []
for i in range(n):
    commands = input().split()
    command = commands[0]
    num = -1
    if len(commands) > 1:
        num = commands[1]

    if command == "push":
        stack.append(num)
    elif command == "pop":
        if len(stack)==0:
            print(-1)
        else:
            print(stack.pop())
    elif command =="size":
        print(len(stack))
    elif command == "empty":
        if len(stack)==0:
            print(1)
        else:
            print(0)
    elif command =="top":
        if len(stack)==0:
            print(-1)
        else:
            print(stack[-1])
