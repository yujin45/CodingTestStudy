from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = deque([0 for _ in range(bridge_length)])
    trucks = deque(truck_weights)

    total_weights = 0 # 현재 다리 총 무게
    trucks_count = len(truck_weights) # 건너야 하는 트럭 수
    time = 0
    
    while trucks_count > 0:
        time += 1
        done_truck = bridge.popleft()
        if done_truck > 0:
            trucks_count -= 1
            total_weights -= done_truck
        
        if trucks:
            check = total_weights + trucks[0]
            if check <= weight:
                # 적재 가능
                truck = trucks.popleft()
                total_weights += truck
                bridge.append(truck)
            else:
                # 적재 불가능
                bridge.append(0)
            
    
    return time