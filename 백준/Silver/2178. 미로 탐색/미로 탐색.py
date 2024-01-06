
from collections  import deque
# N x M 배열로 표현되는 미로 존재
N, M = map(int, input().split())

# 1은 이동할 수 있는 칸 = 간선 연결 o
# 0은 이동할 수 없는 칸 = 간선 연결 x
# (1, 1)에서 출발해서 (N, M)의 위치로 이동시 최소 칸 수 => BFS
# 칸 셀 때 시작, 도착도 포함 = 방문한 노드의 개수

graph = []

'''
# N개의 줄에 M개의 정수 미로 붙어서 입력으로 주어짐
for i in range(N):
    # 아마 붙어서 입력인데 M개로 제한시킨 것은 잘라내라는 의미
    row = int(input())
    row = row[:M] # M개까지만 사용
    # 근데 앞에서 푼 DFS, BFS 응용하려면 graph 행렬로 만들어야 하는뎁...
    # 킁 냅다 리스트로 만들어서 추가해야징
    graph.append(row)
##########그래프 행렬 만들기 완료
print(graph[0][0]==1)
'''

# 붙어서 입력된다는거에 BOLD 되어 있던 이유가 있었군
# 붙어서 입력 = input().rstrip()
for _ in range(N):
    graph.append(list(map(int, input().rstrip()))) 
# readline의 경우 맨 뒤 '\n'까지 입력받아서 제거해줘야 한다고 함
    




# 어 이거.... 그 처음 풀었던거랑 다른거다
# 얼음 먹기? 그거다 이런
# ★★★
# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    # 시작점 주면
    queue = deque()
    queue.append((x, y)) # 튜플로 노드 큐에 삽입
    while queue:
        x, y = queue.popleft() # 큐에서 뽑기
        # 방문했음. 근데 이건 방문했다고 표시하지 않는군 음.
        for i in range(4):
            # 상하좌우 4방향을 탐색해줄거임
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<= nx < N and 0<=ny <M and graph[nx][ny] ==1:
                # 이동한 곳이 그래프 안에 존재하고, 그곳이 노드가 있는 곳이라면
                queue.append((nx, ny)) # 노드 큐에 추가
                graph[nx][ny] = graph[x][y] +1 # 이동한 값을 카운트 하기 위한 것 1만큼 이동했다 표시
    return graph[N-1][M-1] # 가장 마지막에 방문한 노드에 저장되닌 값이 카운트 된 값

print(bfs(0,0))