from collections import deque

def bfs(graph, x, y):
    queue = deque([(x, y)])
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    while queue:
        (cx, cy) = queue.popleft()
        
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0<= nx <len(graph) and 0<= ny <len(graph[0]):
                if graph[nx][ny]!=0 and graph[nx][ny] == 1:
                    graph[nx][ny] += graph[cx][cy]
                    queue.append((nx, ny))
            
    
def solution(maps):
    n = len(maps)
    m = len(maps[0])
    # 벽으로 막힌 경우 바로 리턴
    if maps[n-2][m-1] == 0 and maps[n-1][m-2] == 0:
        return -1
    
    bfs(maps, 0, 0)
    return maps[n-1][m-1] if maps[n-1][m-1] > 1 else -1