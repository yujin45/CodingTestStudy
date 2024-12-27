import sys
input = sys.stdin.readline

n = int(input().strip())
now = dict()
for i in range(n):
    name, state = input().strip().split()
    if state == "enter":
        now[name] = True
    else:
        del now[name]

sortedList =  sorted(now.keys(), reverse = True)
print('\n'.join(sortedList))