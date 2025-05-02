from collections import deque

def isDiffOne(current, word):
    count = 0
    for c, w in zip(current, word):
        if c != w:
            count += 1
        if count > 1:
            return False
    return True if count == 1 else False

def solution(begin, target, words):
    queue = deque([(begin, 0)])
    visited = set() # 방문한 단어 체크용
    
    while queue:
        current, current_count = queue.popleft()
        if current == target:
            return current_count
        for word in words:
            if word not in visited:
                if isDiffOne(current, word):
                    visited.add(word)
                    queue.append((word, current_count + 1))
    
    return 0