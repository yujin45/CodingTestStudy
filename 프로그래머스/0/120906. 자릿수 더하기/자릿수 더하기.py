def solution(n):
    answer = 0
    for k in str(n):
        answer += int(k)
    return answer