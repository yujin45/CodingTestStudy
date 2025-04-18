from collections import deque

def diff_one(word1, word2):
    return sum(a != b for a, b in zip(word1, word2)) == 1

def bfs(begin, words, target):
    queue = deque([(begin, 0)])  # (현재 단어, 변환 횟수)
    visited = set()
    
    while queue:
        current, steps = queue.popleft()
        if current == target:
            return steps
        
        for word in words:
            if word not in visited and diff_one(current, word):
                visited.add(word)
                queue.append((word, steps + 1))
    
    return 0  # 변환 불가

def solution(begin, target, words):
    if target not in words:
        return 0
    return bfs(begin, words, target)
