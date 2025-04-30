from collections import deque

def solution(priorities, location):
    waiting_queue = deque()
    for i, p in enumerate(priorities):
        waiting_queue.append((i, p))
    
    count = 0
    while waiting_queue:
        current = waiting_queue.popleft()
            
        if any(current[1] < p for _, p in waiting_queue):
            waiting_queue.append(current)
        else:
            count += 1
            if current[0] == location:
                return count
    
    return count