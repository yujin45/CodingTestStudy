from collections import deque

def solution(bridge_length, weight, truck_weights):
    done = 0
    total_weight = 0
    time = 0
    
    bridge = deque([0 for _ in range(bridge_length)]) # 0으로 초기화된 다리
    trucks = deque(truck_weights) # 트럭들
    
    while done < len(truck_weights):
        done_truck = bridge.popleft()
        total_weight -= done_truck
        if done_truck != 0:
            done += 1
        
        if trucks:
            if trucks[0] + total_weight <= weight:
                truck = trucks.popleft()
                total_weight += truck
                bridge.append(truck)
            else:
                bridge.append(0)
        else:
            bridge.append(0)        
        time += 1
    
    return time