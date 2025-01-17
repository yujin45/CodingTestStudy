import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
cards = list(map(int, input().split()))

pick = list(combinations(cards, 3))

for i in range(len(pick)):
    pick[i] = sum(pick[i])

pick.sort()
ret = 0
for p in pick:
    if p <= m:
        ret = p
    else:
        break
print(ret)
