def solution(score):
    # 1. 평균 계산 및 인덱스 저장
    avg_with_index = [(i, (s[0]+s[1])/2) for i, s in enumerate(score)]
    
    # 2. 평균 기준 정렬
    sorted_avg = sorted(avg_with_index, key = lambda x : x[1], reverse = True)
    
    # 3. 등수 매기기
    ranks = [0] * len(score)
    rank = 1
    
    for i in range(len(sorted_avg)):
        if i > 0 and sorted_avg[i][1] == sorted_avg[i-1][1]:
            rank = ranks[sorted_avg[i-1][0]] # 이전 학생과 동일 등수
        else:
            rank = i+1 # 현재 순위 
        ranks[sorted_avg[i][0]] = rank
    return ranks