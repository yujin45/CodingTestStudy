import sys
from collections import deque

input = sys.stdin.readline

# 입력 처리
n = int(input())
t = int(input())
hand_apartment = deque(map(int, input().split()))
b_calls = list(map(int, input().split()))

# 결과 저장 리스트
results = []

for b_j in b_calls:
    # 패배자 위치 계산
    idx = (b_j-1) % len(hand_apartment)
    loser = hand_apartment[idx]
    #print(idx, (b_j-1), len(hand_apartment), loser)
    #결과 추가
    results.append(loser)
    # 손 아파트 회전
    hand_apartment.rotate(-(b_j-1)) # 왼쪽으로 |n|칸 이동. 큐여서


print(' '.join(map(str, results)))

