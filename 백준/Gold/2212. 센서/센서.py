
import sys

input = sys.stdin.readline

# 입력 처리
N = int(input())
K = int(input())
sensors = list(map(int, input().split()))

###

# 센서가 집중국 수보다 적거나 같으면 각 센서에 하나씩 설치 가능
# 길이 합은 0
if K >= N:
    print(0)
    exit(0)
    
sensors.sort()
# 센서 간격 차이를 계산(인접한 센서 사이 거리)
gaps = []
for i in range(1, N):
    gap = sensors[i] - sensors[i-1]
    gaps.append(gap)

# 간격을 내림차순 정렬 (큰 간격부터 끊기 위해)
gaps.sort(reverse = True)

# (k-1)개의 큰 간격 제거 -> 묶음이 k개 됨
# 전체 구간 길이 = 센서 전체 범위 길이 합
# 큰 간격을 빼주면 최소 구간 길이 합이 됨
answer = sum(gaps[K - 1:])
print(answer)
