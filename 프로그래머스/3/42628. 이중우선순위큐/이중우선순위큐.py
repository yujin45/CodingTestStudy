import heapq
from collections import defaultdict

def solution(operations):
    max_heap = []
    min_heap = []
    count_dict = defaultdict(int)
    
    for operation in operations:
        if operation.startswith("I"):
            # 삽입
            oper = operation.split(" ")
            num = int(oper[1])
            heapq.heappush(max_heap, -num)
            heapq.heappush(min_heap, num)
            count_dict[num] += 1
        elif operation.startswith("D -"):
            while min_heap:
                num = heapq.heappop(min_heap)
                if count_dict[num] > 0:
                    count_dict[num] -= 1
                    break
        else:
            while max_heap:
                num = -heapq.heappop(max_heap)
                if count_dict[num] > 0:
                    count_dict[num] -= 1
                    break
    
    if not min_heap or not max_heap:
        return [0,0]
    
    max_value = float('-inf')
    min_value = float('inf')
    
    while min_heap:
        num = heapq.heappop(min_heap)
        if count_dict[num] > 0:
            min_value = num
            break
    
    
    while max_heap:
        num = -heapq.heappop(max_heap)
        if count_dict[num] > 0:
            max_value = num
            break
    
    answer = [max_value, min_value]
    return answer