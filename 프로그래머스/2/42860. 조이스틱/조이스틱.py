def solution(name):
    answer = 0
    n = len(name)
    min_move = n - 1

    for i in range(n):
        answer += min(ord(name[i]) - ord('A'), 26 - (ord(name[i]) - ord('A')))
        
        next_idx = i + 1
        while next_idx < n and name[next_idx] == 'A':
            next_idx += 1
        
        # 좌우 이동 최소 계산
        min_move = min(min_move, i + n - next_idx + min(i, n - next_idx))
        
    answer += min_move
    return answer
