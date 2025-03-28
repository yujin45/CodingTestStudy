from collections import deque

def solution(priorities, location):
    queue = deque([(index, value) for index, value in enumerate(priorities)])
    order = 0 # 실행 순서
    
    while queue:
        index, priority = queue.popleft()
        # 뒤에 더 높은 우선순위 있으면 다시 넣기
        if any(priority < q[1] for q in queue):
            queue.append((index, priority))
        else:
            order+=1
            if index == location:
                return order
        