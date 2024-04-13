def solution(arr):
    answer = []
    for a in arr:
        if answer[-1:] == [a]: continue
        answer.append(a)
    return answer