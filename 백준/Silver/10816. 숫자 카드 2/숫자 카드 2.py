import sys
from collections import defaultdict
input = sys.stdin.readline

N = input()
having = list(map(int, input().split()))

having_dict = defaultdict(int)
for h in having:
    having_dict[h]+=1

M = int(input().strip())
check_cards = list(map(int, input().split()))

result = []
for c in check_cards:
    if c in having_dict:
        result.append(having_dict[c])
    else:
        result.append(0)
print(' '.join(map(str, result)))