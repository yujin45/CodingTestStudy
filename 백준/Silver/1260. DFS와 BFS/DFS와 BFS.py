# 정점의 개수 N, 간선 개수 M, 탐색 시작 정점 번호 V
# 이후 M개의 줄에 간선 연결하는 두 정점 전호
# 양방향, 여러 간선 O

# 입력 받기
N, M, V = map(int, input().split())

# 그래프 행렬 초기화 리스트 컴프리헨션 사용
# 인덱스 번호를 정점 번호로 사용하기 위해 N+1개 만들어 준다.
graph = [[0]*(N+1) for _ in range(N+1)]

###이후 주석처리
#print("------초기화 확인용------")
#for row in graph:
#    print(row)

# M개 간선 받아서 이어주기
for _ in range(M):
    a, b = map(int, input().split())
    # 양방향으로 연결된 것 1로 표시
    graph[a][b] = graph[b][a] = 1

###이후 주석처리
#print("------간선 연결 확인용------")
#for row in graph:
#    print(row)

# 방문한 노드 표시용 행렬 # ★★★
visited1 = [0]*(N+1)
visited2 = visited1.copy() # 얘는 bfs에 쓸 것


# dfs
def dfs(V):
    # 정점 V부터 시작
    visited1[V] = 1 # 방문 처리
    print(V, end=" ") # 방문한 것 프린트
    for i in range(1, N+1):
        # 1번 노드부터 쭉 돌면서 확인
        # 연결된 노드가 있고 방문 전이면 다시 방문 하기 위해 dfs
        if graph[V][i] == 1 and visited1[i] == 0:
            dfs(i) # 자식 노드를 싹 돌아

# bfs
def bfs(V):
    # 큐로 노드를 돌면서 처리
    queue = [V] # 일단 방문한거 넣고
    visited2[V] = 1  # 방문처리
    while queue:
        # 방문한게 있으면 연결된거 확인 필요
        V = queue.pop(0) #일단 방문 노드 제거하고
        print(V, end=" ")
        for i in range(1, N+1):
            # 1번 노드부터 N번 노드까지 확인해주기
            if graph[V][i] == 1 and visited2[i] ==0:
                # 그래프 연결되어 있으면서 아직 방문하지 않은 곳이면
                # dfs와 달리 큐에 넣어야 함
                queue.append(i) # i번 노드
                # 그리고 방문처리 필요
                visited2[i] = 1
                
dfs(V)
print()
bfs(V)

