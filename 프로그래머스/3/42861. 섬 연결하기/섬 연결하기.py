def solution(n, costs):
    # 1. 각 노드는 자기 자신을 부모로 초기화
    parent = [i for i in range(n)]
    
    # 2. find: x의 부모를 재귀로 찾아서 반환
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]
    
    # 3. union : 두 노드의 루트 노드가 다르면 합치고 true 반환, 같으면 false
    def union(a, b):
        root_a = find(a)
        root_b = find(b)
        if root_a != root_b:
            parent[root_b] = root_a # 한쪽 루트를 다른 쪽 루트에 붙임
            return True
        return False
    
    # 4. 간선을 비용 기준으로 정렬
    costs.sort(key = lambda x : x[2])
    
    total = 0
    # 5. 간선을 하나씩 보면서 MST 구성
    for a, b, cost in costs:
        if union(a, b): # 연결 성공하면
            total += cost # 비용 누적
    
    # 6. 최소 비용 반환
    return total