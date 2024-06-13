def solution(i, j, k):
    answer = 0
    for m in range(i, j+1):
        # 문자열 내에서 몇번 등장했는가 count하는 것이 포인트
        answer += str(m).count(str(k))
    return answer