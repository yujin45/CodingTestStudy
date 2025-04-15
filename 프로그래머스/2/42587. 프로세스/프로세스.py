from collections import deque

def solution(priorities, location):
    ready_queue = deque()
    
    for i, p in enumerate(priorities):
        ready_queue.append((i, p))
    
    count = 1
    while ready_queue:
        (i, p) = ready_queue.popleft()
        if any(p < rq[1] for rq in ready_queue):
            ready_queue.append((i, p))
        else:
            if i == location:
                return count
            count+=1
    
    return count