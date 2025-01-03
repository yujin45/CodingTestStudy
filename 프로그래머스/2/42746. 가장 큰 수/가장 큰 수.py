#from functools import cmp_to_key

import functools

def comparator(a,b):
    t1 = a+b
    t2 = b+a
    return (int(t1) > int(t2)) - (int(t1) < int(t2)) #  t1이 크다면 1  // t2가 크다면 -1  //  같으면 0

def solution(numbers):
    n = [str(x) for x in numbers]
    n = sorted(n, key=functools.cmp_to_key(comparator),reverse=True)
    answer = str(int(''.join(n)))
    return answer

def solution2(numbers):
    # Step 1: 정렬 기준 정의 (a+b, b+a 비교)
    def compare(a, b):
        if a+b >b+a:
            return -1 # a가 b보다 앞에 와야 함
        elif a+b < b+a:
            return 1 # b가 a 보다 앞에 와야 함
        else:
            return 0 # 순서 상관없음
    
    # Step 2: 숫자 배열을 문자열로 변환
    numbers = list(map(str, numbers))
    
    # Step 3: 사용자 정의 기준으로 정렬
    sorted_numbers = sorted(numbers, key = cmp_to_key(compare))
    
    # Step 4: 정렬된 숫자를 이어 붙여 결과 생성
    result = ''.join(sorted_numbers)
    
    # Step 5: 모든 원소가 0일 경우 "0" 반환
    return "0" if result[0] == "0" else result

# 채점을 시작합니다.
# 정확성  테스트
# 테스트 1 〉	통과 (301.59ms, 21.1MB)
# 테스트 2 〉	통과 (186.86ms, 16MB)
# 테스트 3 〉	통과 (380.22ms, 24.8MB)
# 테스트 4 〉	통과 (6.70ms, 10.3MB)
# 테스트 5 〉	통과 (273.52ms, 19.9MB)
# 테스트 6 〉	통과 (248.66ms, 18.6MB)
# 테스트 7 〉	통과 (0.03ms, 10MB)
# 테스트 8 〉	통과 (0.02ms, 10.1MB)
# 테스트 9 〉	통과 (0.03ms, 10.1MB)
# 테스트 10 〉	통과 (0.02ms, 10MB)
# 테스트 11 〉	통과 (0.03ms, 10.1MB)
# 테스트 12 〉	통과 (0.01ms, 10MB)
# 테스트 13 〉	통과 (0.01ms, 10MB)
# 테스트 14 〉	통과 (0.01ms, 10.1MB)
# 테스트 15 〉	통과 (0.01ms, 10MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0