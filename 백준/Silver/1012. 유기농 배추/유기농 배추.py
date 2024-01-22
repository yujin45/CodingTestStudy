import sys
sys.setrecursionlimit(10**7)

T = int(input()) # 테스트 케이스 수
count = 0
def dfs(x, y):   
    if x <0 or y<0 or x>=N or y>=M:
        return False
    if maps[x][y] == 1:
        # 있으면 재귀 상하좌우
        maps[x][y] =0
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

for _ in range(T):
    # 가로 길이, 세로 길이, 배추 개수 
    M, N, K = map(int, input().split())
    # 열, 행
    
    maps= [[0]*(M) for _ in range(N)]
    # N행 M열
    for _ in range(K):
        X, Y = map(int, input().split())
        #  X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)
        maps[Y][X] = 1
    
    for i in range(N):
        for j in range(M):
            if dfs(i,j) == True:
                count +=1
        
    print(count)
    count = 0   
    