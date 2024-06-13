def solution(score):
    # 각 학생의 평균 점수를 계산합니다.
    averages = [(s[0] + s[1]) / 2 for s in score]
    #print(averages)
    # 평균 점수를 내림차순으로 정렬하고, 등수를 매깁니다.
    sorted_averages = sorted(averages, reverse=True)
    #print(sorted_averages)
    # 각 평균 점수에 대한 등수를 저장할 리스트를 초기화합니다.
    ranks = []
    
    for avg in averages:
        rank = sorted_averages.index(avg) + 1
        ranks.append(rank)
    
    return ranks
