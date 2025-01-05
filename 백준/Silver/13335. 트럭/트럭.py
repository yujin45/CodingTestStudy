import sys
from collections import deque

input = sys.stdin.readline

n, w, L = map(int, input().split())
trucks = deque(map(int, input().split()))

time = 0
bridge_weight = 0  # 다리 위 총 무게
bridge = deque([0] * w)  # 다리 상태 (현재 다리 위의 트럭들)

while trucks or bridge_weight > 0:
    # 시간 경과
    time += 1

    # 다리에서 트럭 내리기
    exited_truck = bridge.popleft()
    bridge_weight -= exited_truck

    if trucks:
        # 다음 트럭이 다리에 올라갈 수 있는지 확인
        if bridge_weight + trucks[0] <= L:
            next_truck = trucks.popleft()
            bridge.append(next_truck)
            bridge_weight += next_truck
        else:
            bridge.append(0)  # 트럭이 못 올라가면 빈 공간 유지

print(time)
