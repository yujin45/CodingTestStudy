def solution(rank, attendance):
    candidates = [(r, i) for i, r in enumerate(rank) if attendance[i]]
    candidates.sort()  # rank 기준 오름차순 정렬
    a, b, c = [i for _, i in candidates[:3]]
    return 10000 * a + 100 * b + c
