import sys

input = sys.stdin.readline

n = int(input())
num_list = [int(input()) for _ in range(n)]

stack = []
command = []
current = 1

for num in num_list:
    while current <= num:
        stack.append(current)
        command.append("+")
        current +=1

    if stack[-1] == num:
        stack.pop()
        command.append("-")
    else:
        print("NO")
        exit()

print("\n".join(command))