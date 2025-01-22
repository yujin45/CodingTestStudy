import sys

input = sys.stdin.readline

year = 1
e, s, m = map(int, input().split())

while True:
    if (year - e) % 15 == 0 and (year - s) % 28 == 0 and (year - m) % 19 == 0:
        print(year)
        break
    year += 1
