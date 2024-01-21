N = int(input()) # 컴퓨터의 수 1번부터 번호
M = int(input()) # 연결 간선


graph = [[0]*(N+1) for _ in range(N+1)] #인덱스를 노드 번호로
# 연결 입력 받기
for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

visited1= [0]*(N+1) # 인덱스 번호가 노드 번호

def dfs(V):
    # 시작 정점이 V 우리는 1번이 될 것임
    visited1[V] = 1
    for i in range(N+1):
        if graph[V][i] == 1 and visited1[i]==0:
            # 연결된 노드이고 방문 안했으면
            dfs(i) # 쭉 방문
            
    # 전체를 다 돌고나서 방문 표시된 노드 확인
    return visited1.count(1)-1 # 1 표시된 노드 개수 반환에 1번째는 빼기

print(dfs(1))