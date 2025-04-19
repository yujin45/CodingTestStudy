import sys

input = sys.stdin.readline

K, N = map(int, input().split())
lan = [int(input()) for _ in range(K)]

left = 1 # 자를 수 있는 것은 1부터!!
right = max(lan)
answer = 0
while left <= right:
    mid = (left + right) // 2
    # 모두 같은 길이 mid로 잘라
    cut = sum(l // mid for l in lan) # left 0이면 zerodivisionerror문제 있음. 주의!

    if cut >= N:
        # 적어도 N이면 일단 저장하고 더 길게 자를 수 있는 것 탐색
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)
