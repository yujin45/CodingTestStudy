def solution(sizes):
    w = 0
    h = 0
    for a, b in sizes:
        w = max(min(a, b), w)
        h = max(max(a, b), h)
    return w*h