def solution(sizes):
    w = 0
    h = 0
    for a, b in sizes:
        w = max(w, min(a, b))
        h = max(h, max(a, b))
    
    return w*h