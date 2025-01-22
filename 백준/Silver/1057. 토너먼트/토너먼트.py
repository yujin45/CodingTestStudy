import sys
from collections import deque

input = sys.stdin.readline


def tornament(n, kim, lim):
    round_count = 0

    queue_a = deque(range(1, n + 1))
    queue_b = deque()

    while len(queue_a) > 1:  # 한 명 남을 때까지 진행
        round_count += 1
        while queue_a:
            # 2명씩 짝지어서 진행하기
            if len(queue_a) > 1:
                p1 = queue_a.popleft()
                p2 = queue_a.popleft()
                # print(p1, p2)
                if (p1 == kim and p2 == lim) or (p1 == lim and p2 == kim):
                    return round_count
                elif p1 == kim or p1 == lim:
                    # p1에 kim, lim 있으면 넣고 아니라면 p2가 그들
                    queue_b.append(p1)
                else:
                    queue_b.append(p2)
            else:
                # 홀수여서 1명 남으면 그냥 넣기
                queue_b.append(queue_a.popleft())

        queue_a, queue_b = queue_b, deque()
    return -1  # 못 만남


n, kim, lim = map(int, input().split())
print(tornament(n, kim, lim))
