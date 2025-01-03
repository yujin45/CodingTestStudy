import sys

input = sys.stdin.readline

user_input = input().strip()

stack = []
ret = []
flag = False
for i in range(len(user_input)):
    user_input_char = user_input[i]
    if user_input_char == '<':
        while len(stack)>0:
            ret.append(stack.pop())
        flag = True
        ret.append(user_input_char)
    elif user_input_char == '>':
        flag = False
        ret.append(user_input_char)
    elif flag:
        ret.append(user_input_char)
    elif not flag and user_input_char==' ':
        while len(stack)>0:
            ret.append(stack.pop())
        ret.append(user_input_char)
    else:
        stack.append(user_input_char)

while len(stack) > 0:
    ret.append(stack.pop())

print(''.join(ret))