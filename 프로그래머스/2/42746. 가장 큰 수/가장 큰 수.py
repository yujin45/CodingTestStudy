import functools

def comparator(a, b):
    # 두 숫자를 문자열로 결합하여 두 가지 경우의 수를 만듭니다.
    t1 = a + b  # 예: a = '3', b = '30'이라면 '330'이 됩니다.
    t2 = b + a  # 예: a = '3', b = '30'이라면 '303'이 됩니다.
    
    # 두 가지 경우의 수를 정수로 변환하여 비교합니다.
    # t1이 크면 1을 반환하고, t2가 크면 -1을 반환합니다.
    # 두 경우가 같으면 0을 반환합니다.
    return (int(t1) > int(t2)) - (int(t1) < int(t2))

def solution(numbers):
    # 주어진 숫자 배열을 문자열 배열로 변환합니다.
    n = [str(x) for x in numbers]
    
    # comparator 함수를 이용하여 문자열 배열을 정렬합니다.
    # reverse=True로 설정하여 내림차순으로 정렬합니다.
    n = sorted(n, key=functools.cmp_to_key(comparator), reverse=True)
    
    # 정렬된 문자열 배열을 다시 합쳐서 가장 큰 수를 만듭니다.
    # 이를 정수로 변환하고 다시 문자열로 변환합니다.
    answer = str(int(''.join(n)))
    
    return answer
