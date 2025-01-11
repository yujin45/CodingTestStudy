import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def dfs(graph, v, visited, parent):
    visited[v] = True
    for neighbor in graph[v]:
        if not visited[neighbor]:
            parent[neighbor] = v  # 탐색할 neighbor의 parent는 현재 v가 됨
            dfs(graph, neighbor, visited, parent)


n = int(input())
graph = [[] for _ in range(n + 1)]  # 0은 사용x
parent = [0] * (n + 1)
visited = [False] * (n + 1)
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for v in range(1, n + 1):
    if not visited[v]:
        dfs(graph, v, visited, parent)

print('\n'.join(map(str, parent[2:])))
