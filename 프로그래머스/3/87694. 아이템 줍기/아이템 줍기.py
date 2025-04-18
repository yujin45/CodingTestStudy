from collections import deque

def bfs(graph, x, y, tx, ty):
    queue = deque([(x, y)])
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    while queue:
        (cx, cy) = queue.popleft()
        if (cx, cy) == (tx, ty):
            return
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0<= nx < len(graph) and 0<= ny < len(graph[0]):
                if graph[nx][ny] == 1:
                    graph[nx][ny] += graph[cx][cy]
                    queue.append((nx, ny))

def solution(rectangle, characterX, characterY, itemX, itemY):
    # 조건에 좌표값 범위가 1~50이라 아래와 같이 확장해도 됨
    # MAX = 102
    # board = [[0]*MAX for _ in range(MAX)]

    # 좌표 확장
    max_x = max(max(x1, x2) for x1, _, x2, _ in rectangle) * 2 + 2
    max_y = max(max(y1, y2) for _, y1, _, y2 in rectangle) * 2 + 2
    board = [[0] * max_y for _ in range(max_x)]
    
    # 좌표도 확장
    characterX *= 2
    characterY *= 2
    itemX *= 2
    itemY *= 2
    
    # 전체 외곽 채우기 
    scaled = [[k*2 for k in rect] for rect in rectangle] # 2배한 것
    for x1, y1, x2, y2 in scaled:
        for i in range(x1, x2+1):
            for j in range(y1, y2+1):
                board[i][j] = 1
    
    # 내부 제거
    for x1, y1, x2, y2 in scaled:
        for i in range(x1+1, x2):
            for j in range(y1+1, y2):
                board[i][j] = 0
    
    # BFS 진행하기
    bfs(board, characterX, characterY, itemX, itemY)
    for b in board:
        print(b)
        
    
    return board[itemX][itemY] //2 # 2배 확장 좌표여서 다시 절반으로 해줘야 함!