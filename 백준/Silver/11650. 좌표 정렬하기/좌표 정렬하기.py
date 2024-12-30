import sys

input = sys.stdin.readline

n = int(input())
list = []
for i in range(n):
    x, y = map(int, input().split())
    list.append([x, y])
list.sort(key=lambda x: (x[0], x[1]))

for x, y in list:
    print(x, y)