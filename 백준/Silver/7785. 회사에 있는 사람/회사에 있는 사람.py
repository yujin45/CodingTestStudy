import sys
input = sys.stdin.readline

n = int(input().strip())
workingSet = set()
for _ in range(n):
    name, state = input().split()
    if state =="enter":
        workingSet.add(name)
    else:
        workingSet.remove(name)

sortedList = sorted(workingSet, reverse = True)
print("\n".join(sortedList))