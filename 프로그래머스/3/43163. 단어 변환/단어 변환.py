from collections import deque

def isDiffOne(curr, word):
    count = 0
    for c, w in zip(curr, word):
        if c != w:
            count += 1
        if count > 1:
            return False
    return True if count == 1 else False

def solution(begin, target, words):
    # 변환할 수 없는 경우 초기 종료
    if target not in words:
        return 0
    
    queue = deque([(begin, 0)])
    visited = set()
    visited.add(begin)
    
    while queue:
        curr, depth = queue.popleft()
        if curr == target:
            return depth
        for word in words:
            if word not in visited and isDiffOne(curr, word):
                # 아직 방문 전이고 word랑 1개만 다르면 
                queue.append((word, depth+1))
                visited.add(word)
    
    return 0