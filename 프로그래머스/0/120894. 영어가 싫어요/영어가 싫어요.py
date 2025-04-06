
def solution(numbers):
    answer = 0
    # 생각1 replace로 냅다 다 바꿔주기
    # 생각2 dict 만들어서 바꿔주기 => 문자열이 공백으로 나눠져 있지 않으므로 패스
    # 생각3 인덱스에서 찾아다 바꾸기
    change = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    for i in range(len(change)):
        numbers = numbers.replace(change[i], str(i))
    return int(numbers)