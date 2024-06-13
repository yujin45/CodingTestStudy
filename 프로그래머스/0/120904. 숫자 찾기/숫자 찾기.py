def solution1(num, k):
    answer = -1
    if str(k) in str(num):
        answer = str(num).find(str(k)) +1
    return answer


def solution(num, k):
    for i, n in enumerate(str(num)):
        if str(k) == n:
            return i + 1
    return -1
