import sys
from collections import deque

input = sys.stdin.readline

t = int(input())
min_char = ''

for _ in range(t):
    n = int(input())
    alpha_list = list(map(str, input().split()))
    ret = deque()

    min_char = alpha_list[0]
    ret.append(min_char)

    for i in range(1, len(alpha_list)):
        if min_char >= alpha_list[i]:
            # 같아도 앞으로 보내야 함

            min_char = alpha_list[i]
            ret.appendleft(min_char)
        else:
            #  뒤로 보내기
            ret.append(alpha_list[i])

    print(''.join(ret))
