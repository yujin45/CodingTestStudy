def solution(people, limit):
    # 1명 이상 50000명 이하
    if len(people) == 1:
        return 1
    
    answer = 0
    left, right = 0, len(people) - 1
    
    people.sort()
    while left <= right:
        if left == right:
            # 둘이 같아졌으면 하나로 보내기
            answer += 1
            break
        if people[left] + people[right] <= limit:
            # 탑승 가능
            answer += 1
            left += 1
            right -= 1
        else:
            # 둘이 같이 탑승 못하면 무거운 것만 보내기
            answer += 1
            right -= 1
        
    
    
    return answer