import sys

input = sys.stdin.readline

n = int(input())
list = []
for i in range(n):
    age, name = map(str, input().split())
    list.append([i, int(age), name])
list.sort(key = lambda x : (x[1], x[0]))
for person in list:
    _, age, name = person
    print(age, name)