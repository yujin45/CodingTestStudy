import heapq
from collections import defaultdict

def solution(operations):
    min_heap = []
    max_heap = []
    validation = defaultdict(int)
    
    for operation in operations:
        op, num = operation.split()
        num = int(num)
        if operation[0] == 'I':
            # 큐에 숫자 삽입
            heapq.heappush(min_heap, num)
            heapq.heappush(max_heap, -num)
            validation[num] = True
        elif operation.startswith('D -'):
            # 최솟값 삭제
            while min_heap:
                temp = heapq.heappop(min_heap)
                if validation[temp] > 0:
                    validation[temp] -= 1
                    break
        else:
            # 최댓값 삭제
            while max_heap:
                temp = -heapq.heappop(max_heap)
                if validation[temp]>0:
                    validation[temp] -=1
                    break
    
    min_val = 0
    max_val = 0
    while max_heap:
        temp = -heapq.heappop(max_heap)
        if validation[temp] > 0:
            max_val = temp
            break
            
    while min_heap:
        temp = heapq.heappop(min_heap)
        if validation[temp] > 0:
            min_val = temp
            break
        
    return [max_val, min_val]