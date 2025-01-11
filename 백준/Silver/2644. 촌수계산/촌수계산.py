import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(graph, p1, p2, visited, count):
    ret = 0
    visited[p1] = True

    if p1 == p2:
        return count

    for neighbor in graph[p1]:
        if not visited[neighbor]:
            result = dfs(graph, neighbor, p2, visited, count+1)
            if result != -1: # 목표 노드에 도달한 경우
                return result
    return -1 # 목표 노드에 도달하지 못한 경우


n = int(input())
p1, p2 = map(int, input().split())
m = int(input())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

count = 0
ret = dfs(graph, p1, p2, visited, count)
print(ret)
