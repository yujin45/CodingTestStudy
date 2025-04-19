import sys

input = sys.stdin.readline

N = int(input())
request = list(map(int, input().split()))
M = int(input())

# 정해진 총액 이하에서 가장 최대의 예싼
left = 0 # 예산 0부터 시작
right = max(request)
answer = 0

if sum(request) <= M:
    answer = max(request)
else:
    while left <= right:
        mid = (left + right) // 2
        cost = 0
        # 모든 요청 배정될 수 있는 경우

        for req in request:
            if req > mid:
                cost += mid
            else:
                cost += req

        if cost <= M:
            # 국가 예산 안으로 되면 더 높여보기
            answer = mid
            left = mid + 1
        else:
            right = mid - 1

print(answer)