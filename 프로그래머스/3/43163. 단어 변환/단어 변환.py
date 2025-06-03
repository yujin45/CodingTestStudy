from collections import deque

def isDiffOne(current, w):
    count = 0
    for a, b in zip(current, w):
        if a != b:
            count+=1
        if count > 1:
            return False
    return True if count == 1 else False
    
def solution(begin, target, words):
    if target not in words:
        return 0
    
    queue = deque([(begin, 0)])
    word_set = set()
    
    while queue:
        current, depth = queue.popleft()
        
        if current == target:
            return depth
        
        for w in words:
            if w not in word_set and isDiffOne(current, w):
                queue.append((w, depth+1))
                word_set.add(w)
        
    return 0