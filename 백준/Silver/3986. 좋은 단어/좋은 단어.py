import sys

input = sys.stdin.readline

n = int(input())

stack = []
ret =0
for _ in range(n):
    user_input = input().strip()
    # 홀수개면 무조건 좋은 단어 안됨
    if(len(user_input)%2==1):
        continue
    stack.clear()
    for char in user_input:
        if not stack:
            stack.append(char)
        elif stack[-1] == char:
            stack.pop()
        else:
            stack.append(char)
    if len(stack)==0:
        ret +=1

print(ret)