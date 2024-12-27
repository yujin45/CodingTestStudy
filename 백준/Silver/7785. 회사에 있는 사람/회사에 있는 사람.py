import sys
input = sys.stdin.readline

n = int(input().strip())
now = set()
for i in range(n):
    name, state = input().strip().split()
    if state == "enter":
        now.add(name)
    else:
        now.remove(name)

for name in sorted(now, reverse= True):
    print(name)
