import heapq
from collections import defaultdict
from dataclasses import dataclass
from collections import deque

@dataclass
class Job:
    id: int
    req_time : int
    duration : int

def solution(jobs):
    total_time = 0 # 총 반환시간
    done  = 0
    n = len(jobs)
    current_time = 0
    
    jobs_list = []
    for i, (req, dur) in enumerate(jobs):
        jobs_list.append(Job(i, req, dur))
    jobs_list.sort(key = lambda job : job.req_time)
    
    job_queue = deque(jobs_list)
    ready_queue = []
    
    while done < n:
        # 모든 작업 처리할 때까지
        while job_queue and job_queue[0].req_time <= current_time:
            job = job_queue.popleft()
            heapq.heappush(ready_queue, (job.duration, job.req_time, job.id, job))
        
        if ready_queue:
            # 대기큐에 있으면
            _, _, _, task = heapq.heappop(ready_queue)
            current_time += task.duration
            total_time += (current_time - task.req_time)
            done += 1
        else:
            current_time = job_queue[0].req_time
        
    
    return total_time // n