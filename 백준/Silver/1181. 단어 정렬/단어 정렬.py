import sys

input = sys.stdin.readline

n = int(input())

voca_set = set()
for _ in range(n):
    voca_set.add(input().strip())
voca_list = list(voca_set)
voca_list.sort(key= lambda x: (len(x), x))
for v in voca_list:
    print(v)