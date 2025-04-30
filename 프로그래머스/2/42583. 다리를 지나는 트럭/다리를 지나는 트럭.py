from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = deque([0 for _ in range(bridge_length)])
    total_weight = 0
    done = 0
    trucks = deque(truck_weights)
    time = 0
    while done < len(truck_weights):
        time += 1
        
        done_truck = bridge.popleft()
        total_weight -= done_truck
        if done_truck != 0:
            done += 1
        
        if trucks and total_weight + trucks[0] <= weight:
            truck = trucks.popleft()
            total_weight += truck
            bridge.append(truck)
        else:
            bridge.append(0)          
    
    
    return time