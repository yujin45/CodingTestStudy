def solution(i, j, k):
    ret = 0
    for m in range(i, j+1):
        ret += str(m).count(str(k))
    return ret