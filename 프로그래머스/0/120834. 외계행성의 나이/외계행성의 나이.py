def solution(age):
    # 유니코드로 바꾸면 'a' = 97, ord('a') =97
    answer = ''
    for a in str(age):
        answer+=chr(int(a)+97)
    return answer