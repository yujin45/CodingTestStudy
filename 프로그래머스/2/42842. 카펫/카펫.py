
def solution(brown, yellow):
    size = brown + yellow
    length = (brown + 4) // 2
    for i in range(1, size+1):
        if i * (length - i) == size:
            a = i
            b = size // a
            return [max(a, b), min(a, b)]
    answer = []
    return answer