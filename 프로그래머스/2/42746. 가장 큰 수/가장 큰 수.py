from functools import cmp_to_key

def compare(a, b):
    if a + b > b + a:
        return -1  # a가 먼저
    elif a + b < b + a:
        return 1   # b가 먼저
    else:
        return 0

def solution(numbers):
    # 숫자들을 문자열로 변환
    numbers_str = list(map(str, numbers))
    
    # 커스텀 정렬
    numbers_str.sort(key=cmp_to_key(compare))
    
    # 합친 결과가 000...일 경우 → "0"으로 처리
    if numbers_str[0] == '0':
        return '0'
    
    return ''.join(numbers_str)
