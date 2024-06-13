def solution(dots):
    dots.sort(key = lambda x : (x[0], x[1]))
    return abs(dots[0][0] - dots[2][0]) * abs(dots[0][1] - dots[1][1])

def solution(dots):
    return (max(dots)[0] - min(dots)[0])*(max(dots)[1] - min(dots)[1])