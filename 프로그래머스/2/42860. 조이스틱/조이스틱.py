# 다시 보기
def solution(name):
    answer = 0
    n = len(name)
    min_move = n - 1

    for i in range(n):
        answer += min(ord(name[i]) - ord('A'), 26 - (ord(name[i]) - ord('A')))
        
        next_idx = i + 1
        while next_idx < n and name[next_idx] == 'A':
            next_idx += 1
        
        # 좌우 이동 최소 계산, J A A B C가 있을 때 
        # i = 0, next_idx = 3, n- next_idx = 2 => i + n - next_idx는 연속 A구간 제외 바꿔야 하는 곳
        # 매 위치마다 직진하는 것이 min인지, 돌아오는 것n-next_idx가 min인지 체크해서 더하기
        min_move = min(min_move, i + n - next_idx + min(i, n - next_idx))
        
    answer += min_move
    return answer
