import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline
isDone = False


def dfs(graph, p1, p2, visited, count):
    ret = 0
    visited[p1] = True
    global isDone
    if p1 == p2:
        isDone = True
        return count

    for neighbor in graph[p1]:
        if not visited[neighbor]:
            if not isDone:
                ret = dfs(graph, neighbor, p2, visited, count + 1)
            else:
                return ret
    return ret


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

print(-1 if ret == 0 else ret)
