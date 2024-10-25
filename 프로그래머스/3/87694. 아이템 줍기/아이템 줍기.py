from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    # 최대 좌표값을 이용해 2배 확장된 맵 생성
    max_x = max(rect[2] for rect in rectangle)
    max_y = max(rect[3] for rect in rectangle)
    
    # 맵을 최대 좌표 기준으로 2배 확장하여 설정 0부터 포함해야 해서 +1
    row = (max_x + 1) * 2
    col = (max_y + 1) * 2
    
    maps = [[0] * col for _ in range(row)]
    #print(max_x, max_y, len(maps), len(maps[0]))
    def print_maps():
        for row in maps:
            print(" ".join(f"{elem:2}" for elem in row))

    # 각 사각형을 확장된 맵에 배치
    for rect in rectangle:
        x1, y1, x2, y2 = rect
        x1, x2 = x1 * 2, x2 * 2
        y1, y2 = y1 * 2, y2 * 2

        # 내부 영역 표시
        for i in range(x1 + 1, x2):
            for j in range(y1 + 1, y2):
                maps[i][j] = -1

        # 테두리 표시
        for i in range(x1, x2 + 1):
            if maps[i][y1] != -1:
                maps[i][y1] = 1
            if maps[i][y2] != -1:
                maps[i][y2] = 1
        for j in range(y1, y2 + 1):
            if maps[x1][j] != -1:
                maps[x1][j] = 1
            if maps[x2][j] != -1:
                maps[x2][j] = 1
    
    #print_maps()
    

    # BFS 탐색을 위해 시작 지점과 목표 지점을 2배 확장하여 설정
    start_x, start_y = characterX * 2, characterY * 2
    target_x, target_y = itemX * 2, itemY * 2

    # BFS 탐색
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    queue = deque([(start_x, start_y)])

    while queue:
        x, y = queue.popleft()
        
        if (x, y) == (target_x, target_y):
            #print_maps()
            return maps[x][y]// 2  # 2배 확장한 좌표이므로 // 2

        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            
            if 0 <= nx < row and 0 <= ny < col and maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                queue.append((nx, ny))
    
    return answer
