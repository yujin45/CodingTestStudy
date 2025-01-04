import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
ret = []
for _ in range(T):
    # n개의 문서, m번째 문서는 언제 인쇄?
    n, m = map(int, input().split())
    # 문서 n개
    priorities = list(map(int, input().split()))

    # 큐에 (초기위치, 중요도) 형태로 저장
    queue = deque([(i, p) for i, p in enumerate(priorities)])
    print_order = 0

    while queue:
        current = queue.popleft()
        # 현재 문서보다 중요도 높은 문서 있는지 확인
        if any(current[1] < q[1] for q in queue):
            queue.append(current) # 뒤로 보내기
        else:
            print_order+=1
            if current[0]==m:
                ret.append(print_order)
                break

print('\n'.join(map(str, ret)))