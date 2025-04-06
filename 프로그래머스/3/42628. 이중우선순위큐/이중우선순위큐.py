import heapq
from collections import defaultdict

def solution(operations):
    min_heap = []
    max_heap = []
    entry_counter = defaultdict(int)

    for op in operations:
        if op[0] == 'I':
            num = int(op[2:])
            heapq.heappush(min_heap, num)
            heapq.heappush(max_heap, -num)
            entry_counter[num] += 1

        elif op == 'D 1':  # 최대값 삭제
            while max_heap:
                num = -heapq.heappop(max_heap)
                if entry_counter[num] > 0:
                    entry_counter[num] -= 1
                    break

        elif op == 'D -1':  # 최소값 삭제
            while min_heap:
                num = heapq.heappop(min_heap)
                if entry_counter[num] > 0:
                    entry_counter[num] -= 1
                    break

    # 남아있는 값들만 정리
    result = [num for num, count in entry_counter.items() if count > 0]

    if not result:
        return [0, 0]
    return [max(result), min(result)]
