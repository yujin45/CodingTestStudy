import sys

input = sys.stdin.readline

# 입력 처리
n = int(input())
t = int(input())
hand_apartment = list(map(int, input().split()))
b_calls = list(map(int, input().split()))

# 결과 저장 리스트
results = []
idx = 0
for b_j in b_calls:
    idx = (idx + (b_j-1)) % len(hand_apartment)
    results.append(hand_apartment[idx])

print(' '.join(map(str, results)))

