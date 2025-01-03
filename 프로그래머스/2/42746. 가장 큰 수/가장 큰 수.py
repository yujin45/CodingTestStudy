from functools import cmp_to_key

def solution(numbers):
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
    