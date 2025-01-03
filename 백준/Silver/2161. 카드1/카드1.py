import sys
input = sys.stdin.readline

n = int(input())
deque = [i for i in range(1, n+1)]
ret = []
while deque:
    ret.append(deque.pop(0)) # 버리기
    if deque:
        temp = deque.pop(0) # 위의 것 뽑아서
        deque.append(temp) # 제일 아래로 두기
    #print(ret, deque)
print(' '.join(map(str, ret)))