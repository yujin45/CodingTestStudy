from collections import deque

def solution(bridge_length, weight, truck_weights):
    # 다리 길이만큼 유지
    bridge = deque([0 for _ in range(bridge_length)])
    trucks = deque(truck_weights)
    current_total_weight = 0 # weight만큼 버티기 가능
    done_trucks = 0
    time = 0
    while done_trucks < len(truck_weights):
        done = bridge.popleft()
        current_total_weight -= done
        if done !=0:
            done_trucks+=1
                
        if trucks and weight >= (current_total_weight + trucks[0]):
            # 탑승 가능
            current_truck = trucks.popleft()
            bridge.append(current_truck)
            current_total_weight += current_truck
        else:
            bridge.append(0)
        time+=1
    
    return time