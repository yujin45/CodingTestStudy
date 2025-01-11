import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def dfs(graph, v, visited):
    visited[v] = True
    for neighbor in graph[v]:
        if not visited[neighbor]:
            dfs(graph, neighbor, visited)


n, m = map(int, input().split())  # n: 정점 / m: 간선
# 방향 없는 그래프 = 양방향
# 인접 리스트로 진행
graph = [[] for _ in range(n + 1)]  # 1~n번 정점 용도
for _ in range(m):
    u, v = map(int, input().split())
    # 방향 없는 그래프 = 양방향
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * (n + 1)
total_count = 0
for v in range(1, n + 1):
    if not visited[v]:
        total_count += 1
        dfs(graph, v, visited)
print(total_count)
