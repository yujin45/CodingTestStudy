from collections import deque

def extract_block(board, target):
    blocks = []
    n = len(board) # 정사각형
    visited=[[False]*n for _ in range(n)]
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    #########
    def bfs(x, y):
        #print("----------bfs x, y : " + str(x) + " " + str(y))
        queue = deque([(x, y)])
        block = [(x, y)]
        visited[x][y] = True
        while queue:
            cx, cy = queue.popleft()
            
            for dx, dy in directions:
                nx = cx + dx
                ny = cy + dy
                
                if 0<= nx <n and 0<=ny <n and not visited[nx][ny] and board[nx][ny] == target:
                    #print("nx, ny : " + str(nx) + " " + str(ny))
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    block.append((nx, ny))
                    
        # 0, 0 기준 정규화     어떻게 하더라
        #print(block)
        min_x = min(b[0] for b in block)
        min_y = min(b[1] for b in block)
        normalized_block = [(x - min_x, y-min_y) for x, y in block]
        #print(normalized_block)
        
        return sorted(normalized_block)

    #########
    
    for i in range(n):
        for j in range(n):
            if not visited[i][j] and board[i][j] == target:
                blocks.append(bfs(i, j))
    
    return blocks


def print_board(board):
    for row in board:
        print(row)

        
def rotate90_matrix(x, y):
    # (1, 2)=> (2, -1)
    return (y, -x)
def rotate90_blocks(blocks):
    rotated_blocks = []
    for block in blocks:
        #print("---------block 회전 : " + str(block))
        rblock = block
        rblocks =[]
        for i in range(4):
            
            rblock = [rotate90_matrix(x, y) for x, y in rblock]
            #print("---------block 회전 완료 : " + str(i)+ "번째------ " + str(rblock))
            # 회전하고 변화한 것에 따른 정규화 필요
            min_x = min(b[0] for b in rblock)
            min_y = min(b[1] for b in rblock)
            normalized_rotated_block = [(x -min_x, y - min_y) for x, y in rblock]
            rblocks.append(sorted(normalized_rotated_block))
            rblock = normalized_rotated_block
            #print("---------block 정규화 완료 : " + str(i)+ "번째------ " + str(normalized_rotated_block))
        rotated_blocks.append(tuple(rblocks))
    
    return rotated_blocks

def solution(game_board, table):
    answer = 0
    # [[block에 해당하는 좌표], [(0, 0), (1, 0), (1, 3)], [()] ....]
    # 게임 블록을 추출한다 (정규화 해서)
    game_blocks = extract_block(game_board, 0)
    
    # print_board(game_board)
    # print(game_blocks)
    
    table_blocks = extract_block(table, 1)
    
    # print_board(table)
    # print(table_blocks)
    
    # 회전시킨 블록들을 만든다 
    rotated_table_blocks = rotate90_blocks(table_blocks)
    #print(rotated_table_blocks)
    
    # 매칭되는지 확인한다. 
    total_count = 0
    flag = False
    pass_list =[]
    for game_block in game_blocks:
        #print('-------------------------------------------')
        #print("game_block : "+str(game_block))
        
        for i, rotated_table_block in enumerate(rotated_table_blocks):
            #print("table_block: "+ str(rotated_table_block))
            if i in pass_list:
                continue
            if game_block in rotated_table_block:
                # 회전한 것 중 하나라도 맞으면
                #print("맞음")
                #print(str(game_block) + " ------------- " + str(rotated_table_block))
                total_count += len(game_block) # 게임 블록 크기 넣기
                pass_list.append(i)
                flag = True
                break
            if flag:
                break
        if flag:
            flag = False
            
    
    return total_count