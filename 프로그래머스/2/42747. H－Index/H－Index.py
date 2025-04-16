def solution(citations):
    citations.sort(reverse=True)
    for i, citation in enumerate(citations):
        if i + 1 > citation:
            return i
    return len(citations)
