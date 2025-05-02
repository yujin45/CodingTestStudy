def dfs(graph, v, visited, sub_tree):
    sub_tree[v] = 1
    visited[v] = True
    
    for neighbor in graph[v]:
        if not visited[neighbor]:
            dfs(graph, neighbor, visited, sub_tree)
            sub_tree[v] += sub_tree[neighbor]


def solution(n, wires):
    graph = [[] for _ in range(n+1)]
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)
    
    sub_tree = [0] * (n+1)
    visited = [False] * (n+1)
    dfs(graph, 1, visited, sub_tree)
    
    for i in range(1, n+1):
        sub_tree[i] = abs(sub_tree[i] - (n - sub_tree[i]))
    
    return min(sub_tree[1:])