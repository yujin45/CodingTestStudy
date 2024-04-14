import heapq

def solution(jobs):
    answer = 0
    start = -1 # 이전 완료된 시간
    now = 0 # 현재 시점
    heap = []
    i = 0 # 완료 작업 개수
    
    
    while i < len(jobs):
        # 작업이 있는 동안 진행
        
        # 작업을 확인하는데 시작 가능한 작업들을 체크해서 소요시간 짧은 순으로 heap에 넣을겨
        for j in jobs:
            if start < j[0] <= now:
                # 실행 시작 시간이 이전 완료시간 이후여야 하고 현재 시점보다는 전이어야지 
                # 작업 힙에 들어감
                heapq.heappush(heap, (j[1], j[0])) # (수행시간, 실행시점)
            
        # 작업 할 것이 있으면 진행
        if len(heap)>0:
            # C - A - B(현재)
            current = heapq.heappop(heap) # 현재 처리중인 작업
            start = now # start가 C완료였던 것을 A 완료시점으로 = 지금시점으로 업데이트
            now += current[0] # 처리시간 더하기
            answer += (now - current[1]) # 지금 - 작업 수행 시작 시간 = 걸린 시간
            i+=1
        else:
            now+=1 
    answer = answer // len(jobs)
        
    return answer