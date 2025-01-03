import sys

input = sys.stdin.readline

n = int(input())
stack = []
ret = []
for _ in range(n):
    user_input = input().strip()
    if user_input.startswith("1"):
        _, num = user_input.split()
        stack.append(num)
    elif user_input=="2":
        if len(stack) == 0:
            ret.append("-1")
        else:
            temp = stack.pop()
            ret.append(temp)
    elif user_input=="3":
        ret.append(str(len(stack)))
    elif user_input=="4":
        if len(stack)==0:
            ret.append("1")
        else:
            ret.append("0")
    elif user_input =="5":
        if len(stack) == 0:
            ret.append("-1")
        else:
            ret.append(stack[-1])

print('\n'.join(ret))