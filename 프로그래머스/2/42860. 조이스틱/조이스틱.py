def solution(name):
    answer = 0
    n = len(name)
    
    # 각 자리 알파벳 맞추기 최소 이동
    for c in name:
        answer += min(ord(c) - ord('A'), ord('Z') - ord(c) + 1)
    
    # 좌우 이동 최소 구하기
    move = n - 1  # 일단 끝까지 오른쪽으로만 간 경우
    
    for i in range(n):
        next_idx = i + 1
        # next_idx부터 연속된 A 찾기
        while next_idx < n and name[next_idx] == 'A':
            next_idx += 1
        
        # 오른쪽 갔다가 왼쪽으로 돌아오기 vs 왼쪽으로 갔다가 오른쪽으로 돌아오기
        #  i별로 다음 A 덩어리를 찾아 계산
        move = min(move, i + i + n - next_idx, i + 2 * (n - next_idx))
    
    answer += move
    return answer
