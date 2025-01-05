import sys
from collections import deque

input = sys.stdin.readline

n, w, L = map(int, input().split())
trucks = deque(map(int, input().split()))

queue = deque([0 for _ in range(w)])
time = 0

while trucks:
    truck_w = trucks[0]
    queue.popleft()  # 앞에 빼고
    if(sum(queue) + truck_w <= L):
        # 적재 가능
        queue.append(trucks.popleft()) # 올리기
    else:
        # 적재 불가능
        queue.append(0)

    time+=1
# 마지막 적재한 상태이므로 마지막 것이 나가기 위해 w
print(time+w)