dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def rotate90(one_block):
    rotated90 = []
    
    for x, y in one_block:
        rotated90.append((y, -x))
        
    return rotated90

def rotate(one_block):
    rotated_blocks = []
    rotated_blocks.append(one_block)
    for i in range(3):
        one_block = rotate90(one_block)
        rotated_blocks.append(one_block)
        
    return rotated_blocks

def normalize(one_block, sx, sy):
    normalized_block = []
    
    for x, y in one_block:
        normalized_block.append((x-sx, y-sy))
    
    return normalized_block

def dfs(graph, x, y, target, one_block):
    graph[x][y] = 1-target # 0, 1 변경해주는 것
    one_block.append((x, y))
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<= nx < len(graph) and 0<= ny < len(graph[0]):
            if graph[nx][ny] == target:
                dfs(graph, nx, ny, target, one_block)
                
def make_zero_area(board):
    zero_area = []
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 0:
                one_block = []
                dfs(board, i, j, 0, one_block)
                one_block = normalize(one_block, i, j)
                #zero_area.append(rotate(one_block))
                zero_area.append(one_block)
    
    return zero_area

def make_one_area(table):
    one_area = {}
    id = 0
    
    for i in range(len(table)):
        for j in range(len(table[0])):
            if table[i][j] == 1:
                one_block = []
                dfs(table, i, j, 1, one_block)
                one_block = normalize(one_block, i, j)
                #one_area.append(rotate(one_block))
                one_area[id] = rotate(one_block)
                id+=1
    
    return one_area


def match_area(blank, one_area):
    
    for key, value in one_area.items():
        for one_block in value:
            one_block.sort()
            sx = one_block[0][0]
            sy = one_block[0][1]
            one_block = normalize(one_block, sx, sy)
            one_block.sort()
            blank.sort()
            if blank == one_block:
                del one_area[key]
                return len(blank)
    return 0


def solution(game_board, table):
    # game_bord에서 빈칸 좌표 추출 -> 0,0 정규화 -> g
    zero_area = make_zero_area(game_board)
    # for z in zero_area:
    #     print(z)
    # print("=-------------------")
    # table에서 1칸 좌표 추출 -> 0,0 정규화 -> t
    ## rotate된 것 저장해두기
    one_area = make_one_area(table)
    # for key, value in one_area.items():
    #     print(f"{key}:{value}\n")
        
    # g에 대해서 
    ## t들을 1개씩 매칭
    ### 맞으면 len(t)를 answer에 더하고 tset에서 제거
    total_fill = 0
    for blank in zero_area:
        total_fill += match_area(blank, one_area)
            
    return total_fill