import sys

input = sys.stdin.readline

n, k = map(int, input().split())
people = list(range(1, n+1))
result = []
index = 0 # 제거할 사람 초기 인덱스

while people:
    # K번째 사람의 인덱스
    index  = (index + k - 1) % len(people)
    # 계산된 인덱스 사람 제거하여 결과에 추가
    result.append(people.pop(index))

print("<"+", ".join(map(str, result))+">")