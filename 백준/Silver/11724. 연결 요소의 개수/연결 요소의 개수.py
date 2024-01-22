import sys
sys.setrecursionlimit(10000)
# 정점과 간선
N, M = map(int, input().split())
# 인덱스 번호를 노드 번호로 사용
graph = [[0]*(N+1) for _ in range(N+1)]

for _ in range(M):
    #간선 입력
    a, b = map(int, input().split())
    # 무방향 = 양방향으로 연결
    graph[a][b] = graph[b][a] = 1

# 인덱스 번호를 노드 번호로 사용
visited = [0]*(N+1)

def dfs(v):
    # 방문 처리
    visited[v] = 1
    # 연결된 노드 확인하여 방문 x 연결o 노드에 대해 dfs 수행
    for i in range(N+1):
       if visited[i] == 0 and graph[v][i] == 1:
           dfs(i)
count = 0
# 모든 노드 체크
for i in range(1, N+1):
    # 방문 안 한 곳에 대해 dfs 수행
    if visited[i] == 0:
        dfs(i)
        count+=1
 
print(count)       
    