import sys
input = sys.stdin.readline

N, M = map(int, input().strip().split())

num_name = dict()
name_num = dict()
for i in range(1, N+1):
    name = input().strip()
    num_name[i] = name
    name_num[name] = i

for _ in range(M):
    user_input = input().strip()
    if user_input.isdigit():
        print(num_name[int(user_input)])
    else:
        print(name_num[user_input])