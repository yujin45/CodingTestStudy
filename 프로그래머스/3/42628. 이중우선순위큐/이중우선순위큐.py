import heapq

def solution(operations):
    min_heap = []
    max_heap = []
    entry_finder = dict() # id: 유효성 표시용
    
    id_counter = 0 # 각 값마다 고유 ID를 부여
    
    for op in operations:
        if op[0] == 'I':
            num = int(op[2:])
            heapq.heappush(min_heap, (num, id_counter))
            heapq.heappush(max_heap, (-num, id_counter))
            entry_finder[id_counter] = True
            id_counter += 1
        elif op == "D 1":
            # 최댓값 삭제
            while max_heap:
                value, idx = heapq.heappop(max_heap)
                # 현재 entry_finder를 통해서 있는 idx에 해당하는 것을 제거하기 위함
                if entry_finder.get(idx, False):
                    entry_finder[idx] = False
                    break
        elif op == 'D -1':
            # 최솟값 삭제
            while min_heap:
                value, idx = heapq.heappop(min_heap)
                if entry_finder.get(idx, False):
                    entry_finder[idx] = False
                    break
                    
    # 남아 잇는 유효한 값 찾기
    min_val = None
    while min_heap:
        value, idx = heapq.heappop(min_heap)
        if entry_finder.get(idx, False):
            min_val = value
            break
    
    max_val = None
    while max_heap:
        value, idx = heapq.heappop(max_heap)
        if entry_finder.get(idx, False):
            max_val = -value
            break
            
    if min_val is None or max_val is None:
        return [0, 0]
    else:
        return [max_val, min_val]
            