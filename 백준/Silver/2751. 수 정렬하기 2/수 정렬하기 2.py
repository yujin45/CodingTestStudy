import sys
input = sys.stdin.readline

n = int(input())
ret = [int(input().strip()) for _ in range(n)]
print('\n'.join(map(str, sorted(ret))))