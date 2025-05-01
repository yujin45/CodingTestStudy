import heapq
from dataclasses import dataclass
from collections import deque

@dataclass
class Task:
    num : int
    req_time : int
    time : int
    
def solution(jobs):
    ready_queue = []
    
    t_time = 0 # 반환 시간
    n = len(jobs)
    current_time = 0
    done = 0
    
    # 요청 시간 기준 job 정렬
    job_queue = deque(sorted([Task(num, req_time, time) for num, (req_time, time) in enumerate(jobs)], key = lambda x : x.req_time))
    
    while done < n:
        while job_queue and job_queue[0].req_time <= current_time:
            task = job_queue.popleft()
            heapq.heappush(ready_queue, (task.time, task.req_time, task.num, task))
        
        if ready_queue:
            _, _, _, ptask = heapq.heappop(ready_queue)
            current_time += ptask.time
            t_time += (current_time - ptask.req_time)
            done += 1
        else:
            # 대기중인 작업 없을 때는 시간을 이동시켜줘야 함
            current_time = job_queue[0].req_time
            
    return t_time // done