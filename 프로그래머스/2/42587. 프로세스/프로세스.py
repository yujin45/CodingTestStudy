import heapq
from collections import deque

def solution(priorities, location):
    priority = []
    queue = deque([])
    
    for i, p in enumerate(priorities):
        heapq.heappush(priority, -p)
        queue.append((i, p))
    
    count = 0
    while priority:
        if priority[0] == -queue[0][1]:
            heapq.heappop(priority)
            curr_location, _ = queue.popleft()
            count += 1
            if curr_location == location:
                return count
        else:
            queue.append(queue.popleft())
            
    return 0