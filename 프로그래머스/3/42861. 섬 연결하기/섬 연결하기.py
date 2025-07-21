def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    root_a = find(parent, a)
    root_b = find(parent, b)
    
    if root_a != root_b:
        parent[root_b] = root_a # root_a로 통일
        return True
    return False # 둘이 이미 같은 트리 내 있는 경우

def solution(n, costs):
    parent = [i for i in range(n)] # 부모는 자기 자신으로 초기화
    
    costs.sort(key = lambda x:x[2]) # 비용으로 정렬
    
    total = 0
    for a, b, cost in costs:
        if union(parent, a, b):
            total += cost # 연결 가능하면 비용 누적
    
    return total