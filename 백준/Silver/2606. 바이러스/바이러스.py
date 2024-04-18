# 1번에 연결되어 있는 애들 개수 구하는 것

N = int(input())
M = int(input())

graph = [[0]*(N+1) for _ in range(N+1)]
vistied = [0]*(N+1)
for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a]=1 # 양방향

def dfs(graph, v, visited):
    global count
    visited[v]=1 # 방문 표시
    #print(v, end=" ")
    count+=1

    for i in range(N+1):
        if graph[v][i]==1 and visited[i]==0:
            # 노드 존재하고 방문 전이면
            dfs(graph, i, visited)


count = 0
dfs(graph, 1, vistied)

print(count-1)