
N = int(input())
M = int(input())

graph = {}
for i in range(N+1):
    graph[i] = []

vistied = [0]*(N+1)
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(graph, v, visited):

    visited[v]=1 # 방문 표시
    #print(v, end=" ")

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

    # 전체를 다 돌고나서 방문 표시된 노드 확인
    return visited.count(1) - 1  # 1 표시된 노드 개수 반환에 1번째는 빼기


print(dfs(graph, 1, vistied))