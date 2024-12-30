from collections import Counter
from functools import reduce

def solution(clothes):
    category_count = Counter([category for _, category in clothes])
    answer = reduce(lambda acc, x: acc *(x+1), category_count.values(), 1)
    return answer - 1

def solution1(clothes):
    ckinds = [ckind[1] for ckind in clothes]
    ckinds_dict = Counter(ckinds)
    value_list = list(ckinds_dict.values())
    ret = 1
    for c in value_list:
        ret *= (c+1)
    return ret-1


# 채점을 시작합니다.
# 정확성  테스트
# 테스트 1 〉	통과 (0.03ms, 10.1MB)
# 테스트 2 〉	통과 (0.03ms, 9.98MB)
# 테스트 3 〉	통과 (0.02ms, 10.1MB)
# 테스트 4 〉	통과 (0.03ms, 10.2MB)
# 테스트 5 〉	통과 (0.02ms, 10.2MB)
# 테스트 6 〉	통과 (0.02ms, 10.3MB)
# 테스트 7 〉	통과 (0.03ms, 9.98MB)
# 테스트 8 〉	통과 (0.03ms, 10.1MB)
# 테스트 9 〉	통과 (0.02ms, 10.1MB)
# 테스트 10 〉	통과 (0.02ms, 10.1MB)
# 테스트 11 〉	통과 (0.02ms, 10.2MB)
# 테스트 12 〉	통과 (0.03ms, 10.2MB)
# 테스트 13 〉	통과 (0.03ms, 10.1MB)
# 테스트 14 〉	통과 (0.02ms, 10.3MB)
# 테스트 15 〉	통과 (0.03ms, 9.91MB)
# 테스트 16 〉	통과 (0.03ms, 10.1MB)
# 테스트 17 〉	통과 (0.02ms, 10.3MB)
# 테스트 18 〉	통과 (0.03ms, 10.2MB)
# 테스트 19 〉	통과 (0.02ms, 10.1MB)
# 테스트 20 〉	통과 (0.04ms, 10.1MB)
# 테스트 21 〉	통과 (0.02ms, 10.1MB)
# 테스트 22 〉	통과 (0.02ms, 10.2MB)
# 테스트 23 〉	통과 (0.02ms, 10.3MB)
# 테스트 24 〉	통과 (0.03ms, 10.2MB)
# 테스트 25 〉	통과 (0.03ms, 10.2MB)
# 테스트 26 〉	통과 (0.03ms, 10.2MB)
# 테스트 27 〉	통과 (0.02ms, 10.1MB)
# 테스트 28 〉	통과 (0.03ms, 10.3MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
