def solution(phone_book):
    phone_book.sort()
    # 2중 for문 대신 이렇게 비교하기
    for i in range(len(phone_book)-1):
        # 슬라이싱으로 접두어 부분만 비교하기
        if phone_book[i] == phone_book[i+1][:len(phone_book[i])]:
            return False
    return True