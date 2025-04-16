def solution(sizes):
    w = 0
    h = 0
    for a, b in sizes:
        w = max(w, max(a, b))
        h = max(h, min(a, b))
    return w*h