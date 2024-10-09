def solution(answers):
    # 수포자들의 찍는 패턴
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    # 점수를 계산할 리스트
    scores = [0, 0, 0]
    
    # 각 수포자의 패턴과 정답 비교
    for i, answer in enumerate(answers):
        if answer == p1[i % len(p1)]:
            scores[0] += 1
        if answer == p2[i % len(p2)]:
            scores[1] += 1
        if answer == p3[i % len(p3)]:
            scores[2] += 1
    
    # 가장 높은 점수를 받은 사람(들) 찾기
    max_score = max(scores)
    result = [i + 1 for i, score in enumerate(scores) if score == max_score]
    
    return result

# 테스트 케이스 실행
test_cases = [
    [1, 2, 3, 4, 5],
    [1, 3, 2, 4, 2]
]

results = [solution(tc) for tc in test_cases]
results
