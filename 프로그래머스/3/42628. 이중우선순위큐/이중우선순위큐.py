from collections import defaultdict
import heapq

def solution(operations):
    min_heap = []
    max_heap = []
    valid_dict = defaultdict(int)
    
    for operation in operations:
        if operation[0] == 'I':
            num = int(operation[2:])
            heapq.heappush(min_heap, num)
            heapq.heappush(max_heap, -num)
            valid_dict[num] += 1
        elif operation[:3] == 'D -':
            # 최솟값 삭제
            while min_heap:
                check_num = heapq.heappop(min_heap)
                if valid_dict[check_num] > 0:
                    valid_dict[check_num] -= 1
                    break
                    
        else:
            # 최댓값 삭제
            while max_heap:
                check_num = -heapq.heappop(max_heap)
                if valid_dict[check_num] > 0:
                    valid_dict[check_num] -= 1
                    break
                    
                    
    max_value = 0
    while max_heap:
        check_num = -heapq.heappop(max_heap)
        if valid_dict[check_num] > 0:
            #valid_dict[check_num] -= 1 # 유효값 중 최대 최소라 결과에서는 삭제x
            max_value = check_num
            break
    
    min_value = 0
    while min_heap:
        check_num = heapq.heappop(min_heap)
        if valid_dict[check_num] > 0:
            #valid_dict[check_num] -= 1
            min_value = check_num
            break
    return [max_value, min_value]

test_operations = [
    "I 5", "I 3", "I 7", 
    "D -1",   # 3 삭제
    "D 1",    # 7 삭제
    "D 1",    # 5 삭제 → 큐는 비었음
    "I 6",    # 6 삽입
    "D -1",   # 6 삭제 → 큐는 다시 비었음
    "I 10",   # 10 삽입
    "D 1",    # 10 삭제 → 큐 비었음
    "I 1",    # 1 삽입
    "D 1",    # 1 삭제 → 큐 비었음
    "D -1",   # 비어있는데 삭제 요청 → 무시
    "I 100"   # 100 삽입
]

print(solution(test_operations))