import sys

input = sys.stdin.readline

# 숫자의 최대값
MAX_VALUE = 10000

# 입력 받기
n = int(input())
count = [0] * (MAX_VALUE + 1)

# 숫자 등장 횟수 기록
for _ in range(n):
    count[int(input())] += 1

# 정렬된 결과 출력
for i in range(1, MAX_VALUE + 1):
    if count[i] > 0:
        for _ in range(count[i]):
            print(i)
            