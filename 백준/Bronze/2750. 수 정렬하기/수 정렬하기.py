import sys
input = sys.stdin.readline

n = int(input())
ret = []
for i in range(n):
    ret.append(int(input()))
ret.sort()
for r in ret:
    print(r)