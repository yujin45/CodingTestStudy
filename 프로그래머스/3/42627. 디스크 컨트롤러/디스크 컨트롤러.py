import heapq
from dataclasses import dataclass
from collections import deque

@dataclass
class Task:
    number : int
    request_time : int
    time : int

def solution(jobs):
    ready_queue = []
    
    t_time = 0 # 반환시간 : 작업 종료 - 요청
    n = len(jobs)
    current_time = 0
    done = 0
    
    job_queue = deque(
        sorted([Task(num, rt, t) for num, (rt, t) in enumerate(jobs)],
              key = lambda x: x.request_time
              )
    )
    while done < n:
        while job_queue and current_time >= job_queue[0].request_time:
            task = job_queue.popleft()
            heapq.heappush(ready_queue, (task.time, task.request_time, task.number, task))
        
        if ready_queue:
            _, _, _, ptask = heapq.heappop(ready_queue)
            current_time += ptask.time
            t_time += (current_time - ptask.request_time)
            done +=1
        else:
            # 대기 중인 작업이 없을 때는 시간을 이동시켜줘야 함!
            current_time = job_queue[0].request_time
            
    return t_time // done