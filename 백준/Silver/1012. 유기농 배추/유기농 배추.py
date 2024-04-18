import sys
sys.setrecursionlimit(10000000)
T = int(input())

count = 0
def dfs(x, y):
    # 여기에서 X는 행, Y는 열
    if x <0 or y<0 or x>=N or y>=M:
        return False
    if graph[x][y] == 1:
        # 배추 있으면 지렁이도 있음
        # home+=1 이거랑 비슷한 문제
        graph[x][y] = 0 # 체크했으니 0으로
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    return False

for _ in range(T):
    M, N, K = map(int, input().split())
    #열, 행, 배추 위치 개수
    graph = [[0]*(M) for _ in range(N)]


    for _ in range(K):
        x, y = map(int, input().split())
        # X(0 ≤ X ≤ M-1) 가로 열
        # y 행
        graph[y][x] = 1 # 배추 심기

    count = 0
    for i in range(N):
        for j in range(M):
            if dfs(i, j) == True:
                # 지렁이 있는 곳
                count+=1
    print(count)
