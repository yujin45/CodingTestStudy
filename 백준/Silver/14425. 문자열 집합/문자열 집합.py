import sys
input = sys.stdin.readline
N, M = map(int, input().split())
textList = set([input() for _ in range(N)])
cnt = 0

for i in range(M):
    subText = input()
    if subText in textList:
        cnt+=1
#write(str(cnt)+"\n")
print(cnt)