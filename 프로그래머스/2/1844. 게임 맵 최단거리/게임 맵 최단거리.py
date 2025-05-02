from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    queue = deque([(0, 0)])
    
    while queue:
        cx, cy = queue.popleft()
        if (cx, cy) == (n-1, m-1):
            return maps[cx][cy]
        
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if maps[nx][ny] == 1:
                    maps[nx][ny] += maps[cx][cy]
                    queue.append((nx, ny))
            
    return -1