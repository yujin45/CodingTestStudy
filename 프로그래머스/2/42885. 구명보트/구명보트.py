# 최대 2명씩 탈 수 밖에 없음
# 가능한 최대 적게 구명보트 사용하기
def solution(people, limit):
    # 포인트 : 몸무게가 가장 무거운 사람과 가장 가벼운 사람을 짝지어 태우는 방식
    # 정렬 후 투포인터
    people.sort()
    i = 0 # 가장 가벼운 사람
    j = len(people) - 1 # 가장 무거운 사람
    boat = 0
    
    while i <= j:
        if people[i] + people[j] <= limit:
            i += 1 # 같이 탔으니까 가벼운 쪽도 이동
        j -= 1 # 무거운 쪽은 무조건 태움
        boat += 1
    
    return boat