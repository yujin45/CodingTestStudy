import sys
input = sys.stdin.readline

# 듣 n 보 m
n, m = map(int, input().split())
nm_dict = {}

for _ in range(n):
    nm_dict[input().strip()] = 0


nm_list = []
for _ in range(m):
    name = input().strip()
    if name in nm_dict:
        nm_list.append(name)
print(len(nm_list))
nm_list.sort()
print('\n'.join(nm_list))
