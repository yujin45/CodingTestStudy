def dfs(graph, node, parent, subtree_size):
    subtree_size[node] = 1  # 자기 자신도 포함
    for neighbor in graph[node]:
        if neighbor == parent:
            continue  # 부모 방향으로 다시 가지 않음
        subtree_size[node] += dfs(graph, neighbor, node, subtree_size)
    return subtree_size[node]

def solution(n, wires):
    # 1. 그래프 구성
    graph = [[] for _ in range(n + 1)]
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)

    # 2. 서브트리 크기 계산을 위한 DFS 수행
    subtree_size = [0] * (n + 1)
    dfs(graph, 1, -1, subtree_size)  # 루트 노드에서 DFS 시작

    # 3. 최소 차이 계산
    min_difference = float('inf')
    for a, b in wires:
        # 전선을 끊었을 때, 더 작은 서브트리 크기와 나머지 크기의 차이 계산
        part1 = subtree_size[b] if subtree_size[a] > subtree_size[b] else subtree_size[a]
        part2 = n - part1
        min_difference = min(min_difference, abs(part1 - part2))

    return min_difference
