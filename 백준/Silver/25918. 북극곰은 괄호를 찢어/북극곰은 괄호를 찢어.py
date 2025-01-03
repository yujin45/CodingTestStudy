import sys

input = sys.stdin.readline

n = int(input())
s = input().strip()

need_min_day = 0
total = 0

for c in s:
    if c == '(':
        total +=1
    else:
        total -=1
    need_min_day = max(need_min_day, abs(total)) # 최대 깊이 갱신

if total ==0:
    print(need_min_day)
else:
    # total이 0이 아니면 괄호 개수 같지 않은 것
    print(-1)