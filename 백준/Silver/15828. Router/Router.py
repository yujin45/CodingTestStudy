import sys
from collections import deque

input = sys.stdin.readline

n = int(input())  # 버퍼 크기 N

router = deque()  # 음 크기 제한 어떻게 걸지. isfull 그런거 어케 하지
router_now_size = 0  # 라우터 크기 추적용. 매번 size 구하면 시간 걸리니깐
while True:
    info = int(input())
    if info == -1:
        break
    elif info == 0 and router:
        router.popleft()
        router_now_size -= 1
    else:
        if router_now_size == n:
            continue
        else:
            router.append(info)
            router_now_size += 1

if router:
    print(' '.join(map(str, router)))
else:
    print("empty")