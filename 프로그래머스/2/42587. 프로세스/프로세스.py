from collections import deque

def solution(priorities, location):
    count = 0
    ready_queue = deque()
    
    for i, p in enumerate(priorities):
        ready_queue.append((i, p))
    
    while ready_queue:
        (i, p) = ready_queue.popleft()
        if any(p < rp for (ri, rp) in ready_queue):
            ready_queue.append((i, p))
        else:
            count += 1
            if i == location:
                return count
            
    
    
    return count