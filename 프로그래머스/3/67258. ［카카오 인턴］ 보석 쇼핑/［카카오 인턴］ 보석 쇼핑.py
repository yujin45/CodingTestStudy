from collections import defaultdict

def solution(gems):
    gems_num = len(set(gems))
    gem_dict = defaultdict(int)
    left, right = 0, 0
    min_len = float('inf')
    answer = [0, len(gems)]
    
    gem_dict[gems[0]] = 1
    
    while left <= right and right < len(gems):
        if len(gem_dict) == gems_num:
            # 종류 모두 모으면
            if right - left < min_len:
                min_len = right - left
                answer = [left + 1, right + 1] # 문제는 1부터 시작하는 인덱스
            
            gem_dict[gems[left]] -= 1 # 지우기
            if gem_dict[gems[left]] == 0:
                del gem_dict[gems[left]]
            left += 1
        else:
            right += 1
            if right < len(gems):
                gem_dict[gems[right]] += 1
    
    return answer