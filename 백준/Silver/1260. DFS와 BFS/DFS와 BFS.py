from collections import deque

# 정점 개수: N
# 간선 개수: M
# 탐색 시작 정점: V번 (1부터 시작)
N, M, V = map(int, input().split())

# 번호 탐색 위해 0 포함해서 N+1
visited_bfs = [False]*(N+1)
visited_dfs = [False]*(N+1)
# 인접 행렬로 구현
graph = [[0]*(N+1) for _ in range(N+1)]


def bfs(graph, visited, start_v):
    result = []
    queue = deque([start_v])
    visited[start_v]= True
    while queue:
        v = queue.popleft()
        result.append(v)
        for i in range(N+1):
            if graph[v][i] == 1 and not visited[i]:
                queue.append(i) # 연결 노드 추가
                visited[i]= True
                
    return result    
        
dfs_ret =[]        
def dfs(graph, visited, v):
    visited[v] = True
    dfs_ret.append(v)
    for i in range(N+1):
        if graph[v][i] == 1 and not visited[i]:
            dfs(graph, visited, i)


for _ in range(M):
    # 두 정점의 번호, 여러 간선 o, 양방향
    v1, v2 = map(int, input().split())
    graph[v1][v2] = 1
    graph[v2][v1] = 1

dfs(graph, visited_dfs, V)
#print(dfs_ret)
#print(bfs(graph, visited_bfs, 1))
bfs_ret = bfs(graph, visited_bfs, V)

print(' '.join(map(str, dfs_ret)))
print(' '.join(map(str, bfs_ret)))




