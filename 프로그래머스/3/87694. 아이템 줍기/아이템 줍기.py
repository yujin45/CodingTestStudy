from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    
    # 위치 확대
    characterX, characterY, itemX, itemY = characterX * 2, characterY * 2, itemX * 2, itemY * 2
    MAX_N = 102
    maps = [[0] * MAX_N for _ in range(MAX_N)]
    visited = [[0] * MAX_N for _ in range(MAX_N)]
    
    for rect in rectangle:
        sx, sy, ex, ey = rect
        sx, sy, ex, ey = sx * 2, sy * 2, ex * 2, ey * 2
        
        # 1로 채우기 
        for i in range(sx, ex+1):
            for j in range(sy, ey+1):
                maps[i][j] = 1
        
    for rect in rectangle:
        sx, sy, ex, ey = rect
        sx, sy, ex, ey = sx * 2, sy * 2, ex * 2, ey * 2
        
        
        # 가운데 공간 비우기
        for i in range(sx+1, ex):
            for j in range(sy+1, ey):
                maps[i][j] = 0

    queue = deque([(characterX, characterY, 0)])
    visited[characterX][characterY] = True
    
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    while queue:
        cx, cy, depth = queue.popleft()
        
        if (cx, cy) == (itemX, itemY):
            return depth // 2
        
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0<= nx < MAX_N and 0 <= ny < MAX_N:
                if maps[nx][ny] == 1 and not visited[nx][ny]:
                    queue.append((nx, ny, depth+1))
                    visited[nx][ny] = True
    
    return 0