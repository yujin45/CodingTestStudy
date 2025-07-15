def solution(arr):
    answer = []
    for a in arr:
        if len(answer) == 0 or answer[-1] != a:
            answer.append(a)
    return answer