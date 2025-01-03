import sys

input = sys.stdin.readline

original = input().strip()
boom = input().strip()
stack = []
boom_size = len(boom)

for i in range(len(original)):
    #print(original[i])
    stack.append(original[i])
    if len(stack)>=boom_size and ''.join(stack[-boom_size:]) == boom:
        for _ in range(boom_size):
            stack.pop()
if not stack:
    print("FRULA")
else:
    print(''.join(stack))