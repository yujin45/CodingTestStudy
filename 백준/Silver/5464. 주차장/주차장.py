import sys
from collections import deque
import heapq

input = sys.stdin.readline

# 입력 처리
n, m = map(int, input().split())
parking_price = [int(input()) for _ in range(n)]
m_weight = [0] + [int(input()) for _ in range(m)]  # 차량 번호 1부터 시작

# 주차 상태 관리
available_spaces = list(range(n))  # 빈 공간을 관리하는 힙 (0부터 n-1까지 공간 번호)
heapq.heapify(available_spaces)
parking = [-1] * n  # 주차 공간 상태 (-1: 비어 있음)
waiting_queue = deque()  # 대기 차량
total_price = 0

# 차량 입출입 처리
for _ in range(2 * m):
    order = int(input())

    if order > 0:  # 차량 입장
        if available_spaces:  # 빈 공간이 있는 경우
            space = heapq.heappop(available_spaces)
            parking[space] = order
            total_price += parking_price[space] * m_weight[order]
        else:  # 빈 공간이 없는 경우 대기
            waiting_queue.append(order)

    else:  # 차량 퇴장
        car = -order
        for i in range(n):
            if parking[i] == car:
                parking[i] = -1  # 공간 비우기
                heapq.heappush(available_spaces, i)  # 빈 공간 추가
                break

        # 대기 차량 처리
        if waiting_queue and available_spaces:
            space = heapq.heappop(available_spaces)
            next_car = waiting_queue.popleft()
            parking[space] = next_car
            total_price += parking_price[space] * m_weight[next_car]

# 결과 출력
print(total_price)
