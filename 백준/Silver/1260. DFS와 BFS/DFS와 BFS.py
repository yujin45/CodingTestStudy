N, M, V = map(int, input().split())

graph = [[0]*(N+1) for _ in range(N+1)]

visited1 = [0]*(N+1)
visited2 = visited1.copy()

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1
    # 양방향 노드 이어주기

def dfs(V):
    visited1[V] = 1 # 방문처리
    print(V, end = ' ')
    for i in range(1, N+1):
        if graph[V][i] ==1 and visited1[i] ==0:
            #방문x인 곳 자식 노드 타고 들어가기
            dfs(i)
            
            
def bfs(V):
    queue = [V] # 큐에 넣기
    visited2[V] = 1 # 방문 표시
    while queue:
        #큐에 있으면 일단 pip
        V = queue.pop(0)
        print(V, end = ' ')
        for i in range(1, N+1):
            if graph[V][i] ==1 and visited2[i] ==0:
                # 큐에 넣기
                queue.append(i)
                visited2[i] = 1
                
            
dfs(V)
print()
bfs(V)
                               

  

    