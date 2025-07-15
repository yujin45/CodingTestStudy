from collections import deque

def solution(bridge_length, weight, truck_weights):
    total_weight = 0
    bridge = deque([0] * bridge_length)
    done = 0
    time = 0
    trucks = deque(truck_weights)
    trucks_total_count = len(truck_weights)
    
    while done < trucks_total_count:
        # 먼저 다리 지나게 하기
        done_truck = bridge.popleft()
        if done_truck > 0:
            total_weight -= done_truck
            done += 1
        
        # 트럭 다리에 놓을 수 있는지
        if trucks and total_weight + trucks[0] <= weight:
            truck = trucks.popleft()
            total_weight += truck
            bridge.append(truck)
        else:
            bridge.append(0)      
            
        time+=1
    
    return time