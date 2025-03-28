from collections import deque

def solution(bridge_length, weight, truck_weights):
    queue = deque([0 for _ in range(bridge_length)])
    done = 0 
    now_total_weight = 0
    trucks = deque(truck_weights)
    time = 0
    
    while done < len(truck_weights):
        done_weight = queue.popleft()
        now_total_weight -= done_weight
        if done_weight > 0:
            done +=1
        
        if trucks and trucks[0] + now_total_weight <= weight:
            truck = trucks.popleft()
            queue.append(truck)
            now_total_weight += truck
        else:
            queue.append(0)
        time+=1
        
    return time